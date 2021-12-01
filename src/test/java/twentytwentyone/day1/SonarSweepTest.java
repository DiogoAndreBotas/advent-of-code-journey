package twentytwentyone.day1;

import exception.FileExtensionNotSupportedException;
import helper.TextFileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SonarSweepTest {

    @Test
    @DisplayName("Sonar Sweep has 1 depth measurement and therefore no increases")
    public void singularSonarSweep() {
        File file = new File("./src/test/resources/twentytwentyone/day1/singular_sonar_sweep.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(0, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("Sonar Sweep has several depth measurements and no increases")
    public void sonarSweepWithNoIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_with_no_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(0, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("Sonar Sweep has several depth measurements and they are all increases")
    public void sonarSweepOnlyWithIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_only_with_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(19, sonarSweep.calculateDepthIncreases());
    }

    @Test
    @DisplayName("Sonar Sweep has several depth measurements and mixed increases")
    public void sonarSweepWithMixedIncreases() {
        File file = new File("./src/test/resources/twentytwentyone/day1/sonar_sweep_with_mixed_increases.txt");
        SonarSweep sonarSweep = new SonarSweep(file);

        assertEquals(11, sonarSweep.calculateDepthIncreases());
    }

}
