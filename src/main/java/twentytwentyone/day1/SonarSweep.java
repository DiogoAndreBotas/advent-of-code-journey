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
        List<Integer> measurements = sonarSweeps.map(Integer::parseInt).collect(Collectors.toList());
        int measurementIncreases = 0;

        for (int i = 0; i < measurements.size() - 1; i++) {
            if (measurements.get(i + 1) > measurements.get(i))
                measurementIncreases++;
        }

        return measurementIncreases;
    }

    public int calculateSlidingWindowIncreases() {
        List<Integer> measurements = sonarSweeps.map(Integer::parseInt).collect(Collectors.toList());
        int slidingWindowIncreases = 0;

        for (int i = 0; i < measurements.size() - 3; i++) {
            int currSlidingWindow = measurements.get(i) + measurements.get(i + 1) + measurements.get(i + 2);
            int nextSlidingWindow = measurements.get(i + 1) + measurements.get(i + 2) + measurements.get(i + 3);

            if (nextSlidingWindow > currSlidingWindow)
                slidingWindowIncreases++;
        }

        return slidingWindowIncreases;
    }

}
