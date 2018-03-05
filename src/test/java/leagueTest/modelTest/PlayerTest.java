package leagueTest.modelTest;

import league.model.Player;
import league.model.Team;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PlayerTest {

    @Test
    public void shouldThrowExceptionIfFirstNameIsNull() {

        assertThatThrownBy(() -> new Player(null, "lastName", new Team("Team"))).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldThrowExceptionIfLastNameIsNull() {

        assertThatThrownBy(()-> new Player("firstName",null,new Team("Team"))).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldThrowExceptionIfTeamsNameIsNull() {

        assertThatThrownBy(()-> new Player("firstName","lastName",null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldNotThrowExceptionForNonNullParamsAndShouldAssignGivenParamsToObj() {

        Team team = new Team("Team");
        Player player = new Player("First","Last",team);

        Throwable throwable = catchThrowable(()-> new Player("First","Last",team));
        assertThat(throwable).isNull();

        assertThat(player.getFirstName()).isEqualTo("First");
        assertThat(player.getLastName()).isEqualTo("Last");
        assertThat(player.getTeam()).isEqualTo(team);

    }

}