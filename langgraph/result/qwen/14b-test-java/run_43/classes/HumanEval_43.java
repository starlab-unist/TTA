import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_43 {

    // Source Code
    static class HumanEval_43_Source {
        public static boolean pairsSumToZero(int[] l) {
            for (int i = 0; i < l.length; i++) {
                int l1 = l[i];
                for (int j = i + 1; j < l.length; j++) {
                    if (l1 + l[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class HumanEval_43_Transformed {
        public boolean check_for_zero_sum_pairs(int[] numbers) {
            int index = 0;
            while (index < numbers.length) {
                int current_number = numbers[index];
                int next_index = index + 1;
                while (next_index < numbers.length) {
                    if (current_number + numbers[next_index] == 0) {
                        return true;
                    }
                    next_index += 1;
                }
                index += 1;
            }
            return false;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {},
        {1, -1},
        {2, 3, -2},
        {0, 0},
        {5, 7, 9},
        {-5, -7, -9},
        {1, 2, 3, -3},
        {10, 20, -10, 30},
        {4, 5, 6, 7, 8},
        {0, 1, 2, 3, 4, 5, -5}
    };

    private static final boolean[] expectedResults = {
        false,
        true,
        true,
        true,
        false,
        false,
        true,
        true,
        false,
        true
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[0]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[1]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[2]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[3]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[4]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[5]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[6]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[7]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[8]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_43_Source.pairsSumToZero(testCases[9]), 
                     new HumanEval_43_Transformed().check_for_zero_sum_pairs(testCases[9]));
    }
}