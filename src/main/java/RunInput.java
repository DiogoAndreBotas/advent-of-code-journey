import twentytwentyone.day1.SonarSweep;

import java.io.File;

public class RunInput {

    // Get answers to challenges here :muscle:
    public static void main(String[] args) {
        File file = new File("./src/main/resources/twentytwentyone/input.txt");
        SonarSweep sonarSweep = new SonarSweep(file);
        System.out.println(sonarSweep.calculateDepthIncreases());
    }

}
