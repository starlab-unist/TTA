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

public class HumanEval_163 {

    // Source Code
    static class HumanEval_163_Source {
        public List<Integer> generateIntegers(int a, int b) {
            int lower = Math.max(2, Math.min(a, b));
            int upper = Math.min(8, Math.max(a, b));

            List<Integer> result = new ArrayList<>();
            for (int i = lower; i <= upper; i++) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_163_Transformed {
        public List<Integer> generateIntegers(int a, int b) {
            int lower = Math.max(2, Math.min(a, b));
            int upper = Math.min(8, Math.max(a, b));

            List<Integer> counts = new ArrayList<>();
            for (int current = lower; current <= upper; current++) {
                if (current % 2 == 0) {
                    counts.add(current);
                }
            }

            return counts;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 5},
        {3, 9},
        {6, 2},
        {8, 8},
        {0, 4},
        {7, 7},
        {2, 2},
        {10, 1},
        {5, 5},
        {4, 4}
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[0][0], testCases[0][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[1][0], testCases[1][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[2][0], testCases[2][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[3][0], testCases[3][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[4][0], testCases[4][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[5][0], testCases[5][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[6][0], testCases[6][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[7][0], testCases[7][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[8][0], testCases[8][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_163_Source().generateIntegers(testCases[9][0], testCases[9][1]), 
                     new HumanEval_163_Transformed().generateIntegers(testCases[9][0], testCases[9][1]));
    }
}