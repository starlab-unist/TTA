import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    static class HumanEval_152_Source {
        public List<Integer> compare(List<Integer> game, List<Integer> guess) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < game.size(); i++) {
                result.add(Math.abs(game.get(i) - guess.get(i)));
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_152_Transformed {
        public List<Integer> evaluateDifference(List<Integer> actual, List<Integer> playerGuess) {
            List<Integer> differences = new ArrayList<>();
            int index = 0;
            while (index < actual.size()) {
                differences.add(Math.abs(actual.get(index) - playerGuess.get(index)));
                index++;
            }
            return differences;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)},
        {Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)},
        {Arrays.asList(0, 0, 0), Arrays.asList(1, 1, 1)},
        {Arrays.asList(-1, -2, -3), Arrays.asList(-1, -2, -3)},
        {Arrays.asList(10, 20, 30), Arrays.asList(30, 20, 10)},
        {Arrays.asList(100, 200, 300), Arrays.asList(150, 250, 350)},
        {Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1)},
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 4, 3, 2, 1)},
        {Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 3, 2, 1, 0)},
        {Arrays.asList(-5, -10, -15), Arrays.asList(-15, -10, -5)}
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[8][0], (List<Integer>) testCases[8][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[8][0], (List<Integer>) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_152_Source().compare((List<Integer>) testCases[9][0], (List<Integer>) testCases[9][1]), 
                     new HumanEval_152_Transformed().evaluateDifference((List<Integer>) testCases[9][0], (List<Integer>) testCases[9][1]));
    }
}