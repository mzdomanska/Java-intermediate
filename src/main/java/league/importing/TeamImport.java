package league.importing;

import league.model.Player;
import league.model.Team;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class TeamImport {

    private String fileName;
    private String path;
    private final Team team;

    public TeamImport(String fileName, String path) throws IOException {
        this.fileName = checkNotNull(fileName, "File name was not given");
        this.path = checkNotNull(path, "File path was not given");
        this.team = importTeam();
    }

    public Team getTeam() {
        return team;
    }

    private Team importTeam() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(path));
        checkArgument(!lines.isEmpty(),"File cannot be empty");
        checkArgument(!lines.get(0).isEmpty(),"Team name not found in first line of text file");
        Team newTeam = new Team(lines.get(0));

        for (String s : lines) {
            if (lines.indexOf(s) != 0) {
                String[] player = s.split(" ");
                checkState(player.length == 2, "Player's name in file should contain 2 elements");
                newTeam.addPlayer(new Player(player[0], player[1],newTeam));
            }
        }

        return newTeam;
    }

}
