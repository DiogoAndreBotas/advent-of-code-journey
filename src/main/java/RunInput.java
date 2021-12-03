import exception.InvalidCommandException;
import twentytwentyone.day1.SonarSweep;
import twentytwentyone.day2.Dive;
import twentytwentyone.day3.BinaryDiagnostic;

import java.io.File;

public class RunInput {

    // Get answers to challenges here :muscle:
    public static void main(String[] args) {
        File file = new File("./src/main/resources/twentytwentyone/day3/input.txt");
        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(file);

        System.out.println(binaryDiagnostic.calculatePowerConsumption());
    }

}
