package twentytwentyone.day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryDiagnosticTest {

    @Test
    @DisplayName("calculatePowerConsumption - Binary numbers only contain 0s")
    public void calculatePowerConsumptionAllZeroes() {
        File file = new File("./src/test/resources/twentytwentyone/day3/calculate_power_consumption_zeroes.txt");
        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(file);

        assertEquals(0, binaryDiagnostic.calculatePowerConsumption());
    }

    @Test
    @DisplayName("calculatePowerConsumption - Binary numbers only contain 1s")
    public void calculatePowerConsumptionAllOnes() {
        File file = new File("./src/test/resources/twentytwentyone/day3/calculate_power_consumption_ones.txt");
        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(file);

        assertEquals(0, binaryDiagnostic.calculatePowerConsumption());
    }

    @Test
    @DisplayName("calculatePowerConsumption - Binary numbers contain 0s and 1s")
    public void calculatePowerConsumptionMixedZeroesAndOnes() {
        File file = new File("./src/test/resources/twentytwentyone/day3/calculate_power_consumption_mixed.txt");
        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(file);

        assertEquals(198, binaryDiagnostic.calculatePowerConsumption());
    }

    @Test
    @DisplayName("calculateOxygenGeneratorAndCO2ScrubberRatings - Binary numbers contain 0s and 1s")
    public void calculateOxygenGeneratorAndCO2ScrubberRatingsMixedZeroesAndOnes() {
        File file = new File("./src/test/resources/twentytwentyone/day3/calculate_power_consumption_mixed.txt");
        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(file);

        assertEquals(230, binaryDiagnostic.calculateOxygenGeneratorAndCO2ScrubberRatings());
    }

}
