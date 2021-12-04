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
    private List<String> binaryDiagnostics;
    private final Logger logger = Logger.getLogger("2021 - Day 2 - Dive");

    public BinaryDiagnostic(File file) {
        try {
            binaryDiagnostics = TextFileParser.parse(file).collect(Collectors.toList());
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int calculatePowerConsumption() {
        List<String> binaryStrings = binaryDiagnostics;
        int numberOfBinaries = binaryStrings.get(0).length();
        String gammaRate = "", epsilonRate = "";

        for (int idx = 0; idx < numberOfBinaries; idx++) {
            int finalIdx = idx;

            long numOfZeroes = binaryStrings
                    .stream()
                    .filter(str -> str.charAt(finalIdx) == '0')
                    .count();
            boolean zeroOrOne = numOfZeroes > (binaryStrings.size() / 2);

            gammaRate = gammaRate.concat(zeroOrOne ? "0" : "1");
            epsilonRate = epsilonRate.concat(zeroOrOne ? "1" : "0");
        }

        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
    }

    public int calculateOxygenGeneratorAndCO2ScrubberRatings() {
        return calculateOxygenGeneratorRatings() * calculateCO2ScrubberRatings();
    }

    private int calculateOxygenGeneratorRatings() {
        List<String> oxygenGeneratorRating = new ArrayList<>(binaryDiagnostics);
        int numberOfBinaries = binaryDiagnostics.get(0).length();

        for (int idx = 0; idx < numberOfBinaries && oxygenGeneratorRating.size() > 1; idx++) {
            int finalIdx = idx;
            List<String> zeroes = oxygenGeneratorRating
                    .stream()
                    .filter(str -> str.charAt(finalIdx) == '0')
                    .collect(Collectors.toList());
            List<String> ones = oxygenGeneratorRating
                    .stream()
                    .filter(str -> str.charAt(finalIdx) == '1')
                    .collect(Collectors.toList());
            long zeroCount = zeroes.size(), oneCount = ones.size();

            if (zeroCount > oneCount)
                oxygenGeneratorRating.removeAll(ones);
            else
                oxygenGeneratorRating.removeAll(zeroes);
        }

        return Integer.parseInt(oxygenGeneratorRating.get(0), 2);
    }

    private int calculateCO2ScrubberRatings() {
        List<String> co2ScrubberRating = new ArrayList<>(binaryDiagnostics);
        int numberOfBinaries = binaryDiagnostics.get(0).length();

        for (int idx = 0; idx < numberOfBinaries && co2ScrubberRating.size() > 1; idx++) {
            int finalIdx = idx;
            List<String> zeroes = co2ScrubberRating
                    .stream()
                    .filter(str -> str.charAt(finalIdx) == '0')
                    .collect(Collectors.toList());
            List<String> ones = co2ScrubberRating
                    .stream()
                    .filter(str -> str.charAt(finalIdx) == '1')
                    .collect(Collectors.toList());
            long zeroCount = zeroes.size(), oneCount = ones.size();

            if (zeroCount > oneCount)
                co2ScrubberRating.removeAll(zeroes);
            else
                co2ScrubberRating.removeAll(ones);
        }

        return Integer.parseInt(co2ScrubberRating.get(0), 2);
    }

}