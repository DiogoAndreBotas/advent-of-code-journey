package twentytwentyone.day1;

import exception.FileExtensionNotSupportedException;
import helper.TextFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SonarSweep {
    private Stream<String> sonarSweeps;
    private final Logger logger = Logger.getLogger("2021 - Day 1 - Sonar Sweep");

    public SonarSweep(File file) {
        try {
            sonarSweeps = TextFileParser.parse(file);
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int calculateDepthIncreases() {
        List<String> lines = sonarSweeps.collect(Collectors.toList());
        int measurementIncreases = 0;

        for (int i = 0; i < lines.size() - 1; i++) {
            int currMeasurement = Integer.parseInt(lines.get(i));
            int nextMeasurement = Integer.parseInt(lines.get(i + 1));

            if (nextMeasurement > currMeasurement)
                measurementIncreases++;
        }

        return measurementIncreases;
    }
}
