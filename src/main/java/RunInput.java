import exception.InvalidCommandException;
import twentytwentyone.day1.SonarSweep;
import twentytwentyone.day2.Dive;

import java.io.File;

public class RunInput {

    // Get answers to challenges here :muscle:
    public static void main(String[] args) {
        File file = new File("./src/main/resources/twentytwentyone/day2/input.txt");
        Dive dive = new Dive(file);

        try {
            System.out.println(dive.multiplyHorizontalPositionByDepth());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

}
