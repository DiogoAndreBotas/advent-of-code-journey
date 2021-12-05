package twentytwentyone.day5;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrothermalVentureTest {

    @Test
    @DisplayName("calculatePointsOverlap - the number of points overlap is correct in example")
    public void calculatePointsOverlapInExample() {
        File file = new File("./src/test/resources/twentytwentyone/day5/given_example.txt");
        HydrothermalVenture hydrothermalVenture = new HydrothermalVenture(file);

        assertEquals(5, hydrothermalVenture.calculatePointsOverlap());
    }

    @Test
    @DisplayName("calculatePointsOverlap - the number of points overlap is correct in challenge input")
    public void calculatePointsOverlapInChallengeInput() {
        File file = new File("./src/main/resources/twentytwentyone/day5/input.txt");
        HydrothermalVenture hydrothermalVenture = new HydrothermalVenture(file);

        assertEquals(7318, hydrothermalVenture.calculatePointsOverlap());
    }

}
