import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_135 {

    // Source Code
    static class HumanEval_135_Source {
        public static int canArrange(int[] arr) {
            int ind = -1;
            int i = 1;
            while (i < arr.length) {
                if (arr[i] < arr[i - 1]) {
                    ind = i;
                }
                i += 1;
            }
            return ind;
        }
    }

    // Transformed Code
    static class HumanEval_135_Transformed {
        public int findFirstDecreaseIndex(int[] sequence) {
            int position = -1;
            int index = 1;
            while (index < sequence.length) {
                if (sequence[index] < sequence[index - 1]) {
                    position = index;
                }
                index += 1;
            }
            return position;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},
        {5, 4, 3, 2, 1},
        {1, 3, 2, 4, 5},
        {10, 20, 30, 25, 40},
        {1, 1, 1, 1, 1},
        {1, 2, 3, 3, 2},
        {1},
        {},
        {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1},
        {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[0]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[1]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[2]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[3]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[4]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[5]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[6]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[7]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[8]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_135_Source.canArrange(testCases[9]), 
                     new HumanEval_135_Transformed().findFirstDecreaseIndex(testCases[9]));
    }
}