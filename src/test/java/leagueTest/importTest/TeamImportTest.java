package leagueTest.importTest;

import league.importing.TeamImport;
import league.model.Player;
import league.model.Team;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TeamImportTest {

    @Test
    public void shouldThrowExceptionIfFileNameIsNull() {

        String path = "path";
        assertThatThrownBy(()-> new TeamImport(null,path)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldThrowExceptionIfFilePathIsNull() {

        String name = "name";
        assertThatThrownBy(()-> new TeamImport(name,null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void importTeamThrowsExceptionIfFileIsEmpty() {

        String path = "src/test/resources/league/emptyFile";
        assertThatThrownBy(()-> new TeamImport("emptyFile",path)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void importTeamThrowsExceptionIfFileDoesNotContainTeamsName() {

        String path = "src/test/resources/league/noTeamsName";
        assertThatThrownBy(()-> new TeamImport("noTeamsName", path)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void importTeamThrowsExceptionIfThereIsWrongPlayersNameInGivenFile() {

        String path = "src/test/resources/league/wrongPlayersName";
        assertThatThrownBy(()-> new TeamImport("wrongPlayersName",path)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void importTeamImportsDataFromFileWhenFileHasOnlyTeamsName() {

        String path = "src/test/resources/league/onlyTeamsName";

        try {
            TeamImport teamImport = new TeamImport("onlyTeamsName", path);
            assertThat(teamImport.getTeam().getName()).isEqualTo("FC Barcelona");
            assertThat(teamImport.getTeam().getPlayers()).isEmpty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importTeamImportsDataFromFileAndCreatesNewTeamObjWithGivenData() {

        Team team = new Team("Manchester United F.C.");
        Set<Player> players = new HashSet<>();
        players.add(new Player("Juan", "Mata", team));
        players.add(new Player("Eric", "Bailly", team));
        players.add(new Player("Phil", "Jones", team));

        TeamImport teamImport = null;
        try {
            teamImport = new TeamImport("manchester", "src/test/resources/league/manchester");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(teamImport.getTeam().getName()).isEqualTo(team.getName());
        assertThat(teamImport.getTeam().getPlayers()).isEqualTo(players);


    }

}