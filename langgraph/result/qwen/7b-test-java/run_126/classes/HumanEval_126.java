import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_126 {

    // Source Code
    static class HumanEval_126_Source {
        public static boolean isSorted(int[] lst) {
            Map<Integer, Integer> countDigit = new HashMap<>();
            for (int i : lst) {
                countDigit.put(i, countDigit.getOrDefault(i, 0) + 1);
            }
            for (int value : countDigit.values()) {
                if (value > 2) {
                    return false;
                }
            }
            for (int i = 1; i < lst.length; i++) {
                if (lst[i - 1] > lst[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_126_Transformed {
        public static boolean checkSortedSequence(int[] sequence) {
            Map<Integer, Integer> digitCount = new HashMap<>();
            for (int number : sequence) {
                digitCount.put(number, digitCount.getOrDefault(number, 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : digitCount.entrySet()) {
                if (entry.getValue() > 2) {
                    return false;
                }
            }
            
            int index = 1;
            while (index < sequence.length) {
                if (sequence[index - 1] > sequence[index]) {
                    return false;
                }
                index++;
            }
            
            return true;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},
        {5, 4, 3, 2, 1},
        {1, 1, 2, 2, 3, 3},
        {1, 1, 1, 2, 3},
        {1},
        {},
        {1, 2, 2, 3, 4, 5, 5},
        {10, 9, 8, 7, 6, 5},
        {1, 2, 3, 3, 3, 4, 5},
        {1, 2, 3, 4, 5, 5, 5}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[0]), HumanEval_126_Transformed.checkSortedSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[1]), HumanEval_126_Transformed.checkSortedSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[2]), HumanEval_126_Transformed.checkSortedSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[3]), HumanEval_126_Transformed.checkSortedSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[4]), HumanEval_126_Transformed.checkSortedSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[5]), HumanEval_126_Transformed.checkSortedSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[6]), HumanEval_126_Transformed.checkSortedSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[7]), HumanEval_126_Transformed.checkSortedSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[8]), HumanEval_126_Transformed.checkSortedSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_126_Source.isSorted(testCases[9]), HumanEval_126_Transformed.checkSortedSequence(testCases[9]));
    }
}