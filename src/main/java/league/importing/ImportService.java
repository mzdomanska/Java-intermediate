package league.importing;

import com.google.common.io.Files;
import league.model.Player;
import league.model.Team;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ImportService {

    private final String prefix = "team";

    private final Map<String,Set<Player>> teams = new ConcurrentHashMap<>();

    public Map<String, Set<Player>> getTeams() {
        return teams;
    }

    public ImportService(ScheduledExecutorService executor, int delayInMiliseconds, String fromPath, String processedPath, String errorPath) {

        Runnable lookForNewFiles = () -> {
            File[] files = new File(fromPath).listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().startsWith(prefix)) {

                        StringBuilder sbImport = new StringBuilder();
                        StringBuilder sbProcessed = new StringBuilder();
                        sbImport.append(fromPath + "/" + files[i].getName());
                        sbProcessed.append(processedPath + "/" + files[i].getName());

                        try {
                            TeamImport teamImport = new TeamImport(files[i].getName(),sbImport.toString());
                            Team newTeam = teamImport.getTeam();
                            teams.putIfAbsent(newTeam.getName(),newTeam.getPlayers());
                            System.out.println("File " + files[i].getName() + " was processed");
                            Files.move(new File(sbImport.toString()),new File(sbProcessed.toString()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            try {
                                System.out.println("File " + files[i].getName() + " could not be processed");
                                StringBuilder sbError = new StringBuilder();
                                sbError.append(errorPath + "/" + files[i].getName());
                                Files.move(new File(sbImport.toString()),new File(sbError.toString()));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        executor.scheduleWithFixedDelay(lookForNewFiles,delayInMiliseconds,delayInMiliseconds, TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) {

        String importPath = "src/main/resources/league/import";
        String processedPath = "src/main/resources/league/processed";
        String errorPath = "src/main/resources/league/error";
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        ImportService is = new ImportService(executor,100,importPath,processedPath,errorPath);
        Map<String,Set<Player>> players = is.getTeams();
        System.out.println(players.isEmpty());
    }

}
