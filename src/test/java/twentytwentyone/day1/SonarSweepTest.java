package twentytwentyone.day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SonarSweepTest {

    @Test
    @DisplayName("calculateDepthIncreases - Sonar Sweep has 1 depth measurement and therefore no increases")
    public void singularSonarSweep() {
        File file = new File("./src/test/resources/twentytwentyone/day1/singular_sonar_sweep.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(0, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("calculateDepthIncreases - Sonar Sweep has several depth measurements and no increases")
    public void sonarSweepWithNoIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_with_no_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(0, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("calculateDepthIncreases - Sonar Sweep has several depth measurements and they are all increases")
    public void sonarSweepOnlyWithIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_only_with_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(19, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("calculateDepthIncreases - Sonar Sweep has several depth measurements and mixed increases")
    public void sonarSweepWithMixedIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_with_mixed_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(11, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("calculateSlidingWindowIncreases - Sonar Sweep has several sliding window increases and no increases")
    public void slidingWindowsWithNoIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sliding_windows_with_no_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(0, sonarSweep.calculateSlidingWindowIncreases());
    }

    @Test
    @DisplayName("calculateSlidingWindowIncreases - Sonar Sweep has several sliding window increases and they are all increases")
    public void slidingWindowsOnlyWithIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sliding_windows_only_with_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(17, sonarSweep.calculateSlidingWindowIncreases());
    }

    @Test
    @DisplayName("calculateSlidingWindowIncreases - Sonar Sweep has several sliding window increases and mixed increases")
    public void slidingWindowsWithMixedIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sliding_windows_with_mixed_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(5, sonarSweep.calculateSlidingWindowIncreases());
    }

}
