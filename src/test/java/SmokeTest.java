import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest {

    @Test
    public void testIfAssertJDependencyIsCorrectlyAdded() throws Exception {
        assertThat(true);
    }
}
