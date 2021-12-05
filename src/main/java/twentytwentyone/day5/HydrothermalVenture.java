package twentytwentyone.day5;

import exception.FileExtensionNotSupportedException;
import helper.TextFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HydrothermalVenture {
    private List<String> lines;
    private final Logger logger = Logger.getLogger("2021 - Day 5 - HydrothermalVenture");

    public HydrothermalVenture(File file) {
        try {
            lines = TextFileParser.parse(file).collect(Collectors.toList());
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int calculatePointsOverlap() {
        Set<Coordinate> uniqueCoordinates = new HashSet<>();
        List<Coordinate> countedCoordinates = new ArrayList<>();
        final int[] pointsOverlap = { 0 };

        for (String line: lines) {
            String[] coordinateStrings = line.split(" -> ");

            CoordinateRange coordinateRange = new CoordinateRange(
                new Coordinate(
                    Integer.parseInt(coordinateStrings[0].split(",")[0]),
                    Integer.parseInt(coordinateStrings[0].split(",")[1])
                ),
                new Coordinate(
                    Integer.parseInt(coordinateStrings[1].split(",")[0]),
                    Integer.parseInt(coordinateStrings[1].split(",")[1])
                )
            );

            List<Coordinate> coordinates = coordinateRange.getCoordinateRange();
            coordinates.forEach(coordinate -> {
                if (!uniqueCoordinates.add(coordinate) && !countedCoordinates.contains(coordinate)) {
                    pointsOverlap[0]++;
                    countedCoordinates.add(coordinate);
                }
            });
        }

        return pointsOverlap[0];
    }

}
