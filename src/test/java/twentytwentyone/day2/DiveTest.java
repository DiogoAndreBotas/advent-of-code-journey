package twentytwentyone.day2;

import exception.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiveTest {

    @Test
    @DisplayName("multiplyHorizontalPositionByDepth - commands only contain values equivalent to zero")
    public void multiplyCommandsWithZeroValues() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_zero.txt");
        Dive dive = new Dive(file);

        try {
            assertEquals(0, dive.multiplyHorizontalPositionByDepth());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("multiplyHorizontalPositionByDepth - commands contains different numbers")
    public void multiplyCommandsWithMixedValues() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_mixed_values.txt");
        Dive dive = new Dive(file);

        try {
            assertEquals(150, dive.multiplyHorizontalPositionByDepth());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("multiplyHorizontalPositionByDepth - one command is invalid")
    public void multiplyCommandsWithInvalidCommand() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_invalid_command.txt");
        Dive dive = new Dive(file);

        assertThrows(InvalidCommandException.class, dive::multiplyHorizontalPositionByDepth);
    }

    @Test
    @DisplayName("multiplyHorizontalPositionByDepthWithAim - commands only contain values equivalent to zero")
    public void multiplyCommandsWithAimAndWithZeroValues() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_zero.txt");
        Dive dive = new Dive(file);

        try {
            assertEquals(0, dive.multiplyHorizontalPositionByDepthWithAim());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("multiplyHorizontalPositionByDepthWithAim - commands contains different numbers")
    public void multiplyCommandsWithAimAndWithMixedValues() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_mixed_values.txt");
        Dive dive = new Dive(file);

        try {
            assertEquals(900, dive.multiplyHorizontalPositionByDepthWithAim());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("multiplyHorizontalPositionByDepthWithAim - commands contains different numbers")
    public void multiplyCommandsWithAimAndWithInvalidCommand() {
        File file = new File("./src/test/resources/twentytwentyone/day2/multiply_commands_invalid_command.txt");
        Dive dive = new Dive(file);

        assertThrows(InvalidCommandException.class, dive::multiplyHorizontalPositionByDepthWithAim);
    }

}
