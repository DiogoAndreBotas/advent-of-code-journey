package twentytwentyone.day2;

import exception.FileExtensionNotSupportedException;
import exception.InvalidCommandException;
import helper.TextFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dive {
    private Stream<String> commands;
    private final Logger logger = Logger.getLogger("2021 - Day 2 - Dive");

    public Dive(File file) {
        try {
            commands = TextFileParser.parse(file);
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int multiplyHorizontalPositionByDepth() throws InvalidCommandException {
        int horizontalPosition = 0, depth = 0;
        List<String[]> splitCommands = commands.map(command -> command.split(" ")).collect(Collectors.toList());

        for (String[] splitCommand: splitCommands) {
            int value = Integer.parseInt(splitCommand[1]);
            switch (splitCommand[0]) {
                case "forward" -> horizontalPosition += value;
                case "down" -> depth += value;
                case "up" -> depth -= value;
                default -> throw new InvalidCommandException(splitCommand[0]);
            }
        }

        return horizontalPosition * depth;
    }

    public int multiplyHorizontalPositionByDepthWithAim() throws InvalidCommandException {
        int horizontalPosition = 0, depth = 0, aim = 0;
        List<String[]> splitCommands = commands.map(command -> command.split(" ")).collect(Collectors.toList());

        for (String[] splitCommand: splitCommands) {
            int value = Integer.parseInt(splitCommand[1]);
            switch (splitCommand[0]) {
                case "forward" -> {
                    horizontalPosition += value;
                    depth += value * aim;
                }
                case "down" -> aim += value;
                case "up" -> aim -= value;
                default -> throw new InvalidCommandException(splitCommand[0]);
            }
        }

        return horizontalPosition * depth;
    }

}
