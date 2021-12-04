import twentytwentyone.day4.GiantSquid;

import java.io.File;

public class RunInput {

    // Get answers to challenges here :muscle:
    public static void main(String[] args) {
        File file = new File("./src/main/resources/twentytwentyone/day4/input.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        System.out.println(giantSquid.lastBoardToBingo());
    }

}
