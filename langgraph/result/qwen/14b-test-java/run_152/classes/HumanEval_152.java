import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    public static List<Integer> compare(List<Integer> game, List<Integer> guess) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < game.size(); i++) {
            result.add(Math.abs(game.get(i) - guess.get(i)));
        }
        return result;
    }

    // Transformed Code
    public static List<Integer> evaluateDifference(List<Integer> actual, List<Integer> playerGuess) {
        List<Integer> differences = new ArrayList<>();
        int index = 0;
        while (index < actual.size()) {
            differences.add(Math.abs(actual.get(index) - playerGuess.get(index)));
            index += 1;
        }
        return differences;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3), List.of(1, 2, 3)},
        {List.of(4, 5, 6), List.of(7, 8, 9)},
        {List.of(0, 0, 0), List.of(1, 1, 1)},
        {List.of(-1, -2, -3), List.of(-1, -2, -3)},
        {List.of(10, 20, 30), List.of(30, 20, 10)},
        {List.of(100, 200, 300), List.of(150, 250, 350)},
        {List.of(1, 1, 1, 1, 1), List.of(1, 1, 1, 1, 1)},
        {List.of(1, 2, 3, 4, 5), List.of(5, 4, 3, 2, 1)},
        {List.of(0, 1, 2, 3, 4), List.of(4, 3, 2, 1, 0)},
        {List.of(-5, -10, -15), List.of(-15, -10, -5)}
    };

    @Test
    public void test_0() {
        assertEquals(compare((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]), 
                     evaluateDifference((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(compare((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]), 
                     evaluateDifference((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(compare((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]), 
                     evaluateDifference((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(compare((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]), 
                     evaluateDifference((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(compare((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]), 
                     evaluateDifference((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(compare((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]), 
                     evaluateDifference((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(compare((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]), 
                     evaluateDifference((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(compare((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]), 
                     evaluateDifference((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(compare((List<Integer>) testCases[8][0], (List<Integer>) testCases[8][1]), 
                     evaluateDifference((List<Integer>) testCases[8][0], (List<Integer>) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(compare((List<Integer>) testCases[9][0], (List<Integer>) testCases[9][1]), 
                     evaluateDifference((List<Integer>) testCases[9][0], (List<Integer>) testCases[9][1]));
    }
}