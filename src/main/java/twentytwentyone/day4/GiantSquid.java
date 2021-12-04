package twentytwentyone.day4;

import exception.FileExtensionNotSupportedException;
import helper.TextFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GiantSquid {
    private List<String> lines;
    private final Logger logger = Logger.getLogger("2021 - Day 4 - GiantSquid");

    public GiantSquid(File file) {
        try {
            lines = TextFileParser.parse(file).collect(Collectors.toList());
        } catch (FileExtensionNotSupportedException exception) {
            logger.severe("File extension is not supported");
        } catch (FileNotFoundException exception) {
            logger.severe("File not found");
        }
    }

    public int bingo() {
        Queue<Integer> bingoNumbers = extractBingoNumbers();
        List<List<List<Integer>>> boards = buildBoards();

        while (bingoNumbers.peek() != null) {
            int bingoNumber = bingoNumbers.poll();

            for (List<List<Integer>> board : boards) {
                boolean foundNumber = false;

                for (int rowIdx = 0; rowIdx < board.size() && !foundNumber; rowIdx++) {
                    List<Integer> row = board.get(rowIdx);

                    for (int numberIdx = 0; numberIdx < row.size(); numberIdx++) {

                        if (row.get(numberIdx) == bingoNumber) {
                            row.set(numberIdx, -1);
                            foundNumber = true;
                            int finalNumberIdx = numberIdx;

                            boolean isRowBingo = row
                                    .stream()
                                    .filter(number -> number == -1)
                                    .count() == row.size();
                            boolean isColumnBingo = isRowBingo || board
                                    .stream()
                                    .map(element -> element.get(finalNumberIdx))
                                    .filter(number -> number == -1)
                                    .count() == board.size();
                            if (isRowBingo || isColumnBingo)
                                return calculateFinalScore(bingoNumber, board);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public int lastBoardToBingo() {
        Queue<Integer> bingoNumbers = extractBingoNumbers();
        List<List<List<Integer>>> boards = buildBoards();
        Set<Integer> boardsToSkip = new HashSet<>();

        while (bingoNumbers.peek() != null) {
            int bingoNumber = bingoNumbers.poll();

            for (int boardIdx = 0; boardIdx < boards.size(); boardIdx++) {

                if (boardsToSkip.contains(boardIdx))
                    continue;

                List<List<Integer>> board = boards.get(boardIdx);
                boolean foundNumber = false;

                for (int rowIdx = 0; rowIdx < board.size() && !foundNumber; rowIdx++) {
                    List<Integer> row = board.get(rowIdx);

                    for (int numberIdx = 0; numberIdx < row.size(); numberIdx++) {

                        if (row.get(numberIdx) == bingoNumber) {
                            row.set(numberIdx, -1);
                            foundNumber = true;
                            int finalNumberIdx = numberIdx;

                            boolean isRowBingo = row
                                    .stream()
                                    .filter(number -> number == -1)
                                    .count() == row.size();
                            boolean isColumnBingo = isRowBingo || board
                                    .stream()
                                    .map(element -> element.get(finalNumberIdx))
                                    .filter(number -> number == -1)
                                    .count() == board.size();
                            if (isRowBingo || isColumnBingo)
                                if ((boardsToSkip.size() + 1) == boards.size())
                                    return calculateFinalScore(bingoNumber, board);
                                else
                                    boardsToSkip.add(boardIdx);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public Queue<Integer> extractBingoNumbers() {
        return Arrays
                .stream(lines.get(0).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<List<List<Integer>>> buildBoards() {
        List<List<List<Integer>>> boards = new ArrayList<>();

        for (int i = 2; i < lines.size(); i += 6) {
            boards.add(buildBoard(i));
        }

        return boards;
    }

    public List<List<Integer>> buildBoard(int idx) {
        List<List<Integer>> board = new ArrayList<>();

        for (int i = idx; i < idx + 5; i++) {
            board.add(
                    Arrays
                            .stream(lines.get(i).split(" "))
                            .filter(str -> !str.equals(""))
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(ArrayList::new))
            );
        }

        return board;
    }

    public int calculateFinalScore(int winningNumber, List<List<Integer>> board) {
        return winningNumber * board.stream().flatMap(Collection::stream).filter(number -> number > -1).reduce(0, Integer::sum);
    }

}