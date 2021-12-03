package twentytwentyone.day3;

import exception.FileExtensionNotSupportedException;
import exception.InvalidCommandException;
import helper.TextFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryDiagnostic {
    private Stream<String> binaryDiagnostics;
    private final Logger logger = Logger.getLogger("2021 - Day 2 - Dive");

    public BinaryDiagnostic(File file) {
        try {
            binaryDiagnostics = TextFileParser.parse(file);
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int calculatePowerConsumption() {
        String gammaRate = "", epsilonRate = "";
        List<String> binaryStrings = binaryDiagnostics.collect(Collectors.toList());

        for (int idx = 0; idx < binaryStrings.get(0).length(); idx++) {
            int finalIdx = idx;
            long numOfZeroes = binaryStrings
                    .stream()
                    .map(str -> str.charAt(finalIdx))
                    .filter(character -> character == '0')
                    .count();
            if (numOfZeroes > binaryStrings.size() / 2) {
                gammaRate = gammaRate.concat("0");
                epsilonRate = epsilonRate.concat("1");
            }
            else {
                gammaRate = gammaRate.concat("1");
                epsilonRate = epsilonRate.concat("0");
            }
        }

        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
    }

}