package leagueTest.importTest;

import com.google.common.io.Files;
import league.importing.ImportService;
import league.model.Player;
import league.model.Team;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.delete;
import static org.assertj.core.api.Assertions.assertThat;


public class ImportServiceTest {

    private final String importPathMain = "src/main/resources/league/import";
    private final String importPathTest = "src/test/resources/league/import";
    private final String processedPathTest = "src/test/resources/league/processed";
    private final String errorPathTest = "src/test/resources/league/error";
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    private Map<String,Set<Player>> setup() {
        Team bayern = new Team("Bayern Monachium");
        Player p1 = new Player("Robert","Lewandowski",bayern);
        Player p2 = new Player("Juan","Bernat",bayern);
        Player p3 = new Player("Mats", "Hummels",bayern);
        bayern.addPlayer(p1);
        bayern.addPlayer(p2);
        bayern.addPlayer(p3);
        Map<String,Set<Player>> players = new ConcurrentHashMap<>();
        players.putIfAbsent(bayern.getName(),bayern.getPlayers());
        return players;
    }

    private void copyFiles() {
        File[] files = new File(importPathMain).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String from = importPathMain + "/" + files[i].getName();
                String to = importPathTest + "/" + files[i].getName();
                try {
                    Files.copy(new File(from), new File(to));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void deleteFiles(String fromPath) {
        File[] files = new File(fromPath).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                Path path = FileSystems.getDefault().getPath(fromPath,fileName);
                try {
                    delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void shouldPutImportedTeamToMap() {
        copyFiles();
        Map<String,Set<Player>> players = setup();
        ImportService importService = new ImportService(executor,100,importPathTest,processedPathTest,errorPathTest);
        assertThat(importService.getTeams()).containsValues(players.get("Bayern Monachium"));
        assertThat(importService.getTeams()).containsKeys("Bayern Monachium");
    }
    @Test
    public void shouldMoveFileFromImportToProcessedIfImportWentCorrectly() {
        copyFiles();
        ImportService importService = new ImportService(executor,100,importPathTest,processedPathTest,errorPathTest);

        try {
            executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File[] files = new File(processedPathTest).listFiles();
        File processedFile = new File("src/test/resources/league/processed/teamBayern");
        assertThat(files).contains(processedFile);
    }

    @Test
    public void shouldMoveFileFromImportToErrorIfImportWentIncorrectly() {
        copyFiles();
        ImportService importService = new ImportService(executor,100,importPathTest,processedPathTest,errorPathTest);

        try {
            executor.awaitTermination(5000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File[] files = new File(errorPathTest).listFiles();
        File errorFile = new File("src/test/resources/league/error/teamEmptyFile");
        assertThat(files).contains(errorFile);
    }

    @After
    public void deleteFilesFromImport() {
        deleteFiles(importPathTest);
    }

    @After
    public void deleteFilesFromProcessed() {
        deleteFiles(processedPathTest);
    }

    @After
    public void deleteFilesFromError() {
        deleteFiles(errorPathTest);
    }




}