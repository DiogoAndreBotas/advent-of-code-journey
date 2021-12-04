package twentytwentyone.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiantSquidTest {

    @Test
    @DisplayName("extractBingoNumbers - the extracted numbers are correct")
    public void extractBingoNumbers() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        Queue<Integer> expectedQueue = Stream
            .of(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
            .collect(Collectors.toCollection(LinkedList::new));

        assertEquals(expectedQueue, giantSquid.extractBingoNumbers());
    }

    @Test
    @DisplayName("buildBoard - the first board is retrieved correctly")
    public void buildFirstBoard() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        List<List<Integer>> expectedBoard = new ArrayList<>();
        expectedBoard.add(List.of(22, 13, 17, 11, 0));
        expectedBoard.add(List.of(8, 2, 23, 4, 24));
        expectedBoard.add(List.of(21, 9, 14, 16, 7));
        expectedBoard.add(List.of(6, 10, 3, 18, 5));
        expectedBoard.add(List.of(1, 12, 20, 15, 19));

        assertEquals(expectedBoard, giantSquid.buildBoard(2));
    }

    @Test
    @DisplayName("buildBoard - the last board is retrieved correctly")
    public void buildLastBoard() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        List<List<Integer>> expectedBoard = new ArrayList<>();
        expectedBoard.add(List.of(14, 21, 17, 24, 4));
        expectedBoard.add(List.of(10, 16, 15, 9, 19));
        expectedBoard.add(List.of(18, 8, 23, 26, 20));
        expectedBoard.add(List.of(22, 11, 13, 6, 5));
        expectedBoard.add(List.of(2, 0, 12, 3, 7));

        assertEquals(expectedBoard, giantSquid.buildBoard(14));
    }

    @Test
    @DisplayName("buildBoards - the boards are retrieved correctly")
    public void buildBoards() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        List<List<Integer>> firstBoard = new ArrayList<>();
        firstBoard.add(List.of(22, 13, 17, 11, 0));
        firstBoard.add(List.of(8, 2, 23, 4, 24));
        firstBoard.add(List.of(21, 9, 14, 16, 7));
        firstBoard.add(List.of(6, 10, 3, 18, 5));
        firstBoard.add(List.of(1, 12, 20, 15, 19));

        List<List<Integer>> secondBoard = new ArrayList<>();
        secondBoard.add(List.of(3, 15, 0, 2, 22));
        secondBoard.add(List.of(9, 18, 13, 17, 5));
        secondBoard.add(List.of(19, 8, 7, 25, 23));
        secondBoard.add(List.of(20, 11, 10, 24, 4));
        secondBoard.add(List.of(14, 21, 16, 12, 6));

        List<List<Integer>> thirdBoard = new ArrayList<>();
        thirdBoard.add(List.of(14, 21, 17, 24, 4));
        thirdBoard.add(List.of(10, 16, 15, 9, 19));
        thirdBoard.add(List.of(18, 8, 23, 26, 20));
        thirdBoard.add(List.of(22, 11, 13, 6, 5));
        thirdBoard.add(List.of(2, 0, 12, 3, 7));

        List<List<List<Integer>>> expectedBoards = new ArrayList<>();
        expectedBoards.add(firstBoard);
        expectedBoards.add(secondBoard);
        expectedBoards.add(thirdBoard);

        assertEquals(expectedBoards, giantSquid.buildBoards());
    }

    @Test
    @DisplayName("calculateFinalScore - the final score, given the winning number and board, is correct")
    public void calculateFinalScore() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        int winningNumber = 24;
        List<List<Integer>> thirdBoard = new ArrayList<>();
        thirdBoard.add(List.of(-1, -1, -1, -1, -1));
        thirdBoard.add(List.of(10, 16, 15, -1, 19));
        thirdBoard.add(List.of(18, 8, -1, 26, 20));
        thirdBoard.add(List.of(22, -1, 13, 6, -1));
        thirdBoard.add(List.of(-1, -1, 12, 3, -1));

        assertEquals(4512, giantSquid.calculateFinalScore(winningNumber, thirdBoard));
    }

    @Test
    @DisplayName("bingo - the final score is correctly calculated")
    public void bingo() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        assertEquals(4512, giantSquid.bingo());
    }

    @Test
    @DisplayName("lastBoardToBingo - the final score is correctly calculated")
    public void lastBoardToBingo() {
        File file = new File("./src/test/resources/twentytwentyone/day4/given_example.txt");
        GiantSquid giantSquid = new GiantSquid(file);

        assertEquals(1924, giantSquid.lastBoardToBingo());
    }

}
