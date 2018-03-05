package leagueTest.modelTest;

import league.model.Team;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TeamTest {

    @Test
    public void shouldThrowExceptionIfTeamsNameIsNull() {

        assertThatThrownBy(()-> new Team(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldNotThrowExceptionIfTeamsNameIsNotNullAndShouldAssignGivenParamsToObj() {

        Team team = new Team("Name");

        Throwable throwable = catchThrowable(()-> new Team("Name"));
        assertThat(throwable).isNull();

        assertThat(team.getName()).isEqualTo("Name");
    }

}