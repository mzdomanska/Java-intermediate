package league.importing;

import league.model.Team;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DisplayService {

    private final String importPath = "src/main/resources/league/import";
    private final String processedPath = "src/main/resources/league/processed";
    private final String errorPath = "src/main/resources/league/error";

    private final String prefix = "display";

    public DisplayService(ScheduledExecutorService executor, int delayInMiliseconds) {

        Runnable displayTeam = () -> {

            File[] files = new File(importPath).listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().startsWith(prefix)) {

                        StringBuilder sbImport = new StringBuilder();
                        StringBuilder sbProcessed = new StringBuilder();
                        sbImport.append(importPath + "/" + files[i].getName());
                        sbProcessed.append(processedPath + "/" + files[i].getName());

                        try {
                            TeamImport teamImport = new TeamImport(files[i].getName(),sbImport.toString());
                            Team newTeam = teamImport.getTeam();
                            System.out.println(newTeam);
                            Files.move(new File(sbImport.toString()),new File(sbProcessed.toString()));

                        } catch (IOException e) {
                            System.out.println("File cannot be displayed");
                            try {
                                StringBuilder sbError = new StringBuilder();
                                sbError.append(errorPath + "/" + files[i].getName());
                                Files.move(new File(sbImport.toString()),new File(sbError.toString()));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        executor.scheduleWithFixedDelay(displayTeam, delayInMiliseconds, delayInMiliseconds, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        DisplayService ds = new DisplayService(executorService,100);
    }
}
