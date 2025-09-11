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
                for (int j = i + 1; j < l.length; j++) {
                    if (l[i] + l[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class HumanEval_43_Transformed {
        public boolean checkForZeroSumPairs(int[] numbers) {
            int index = 0;
            while (index < numbers.length) {
                int currentNumber = numbers[index];
                int nextIndex = index + 1;
                while (nextIndex < numbers.length) {
                    if (currentNumber + numbers[nextIndex] == 0) {
                        return true;
                    }
                    nextIndex++;
                }
                index++;
            }
            return false;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{}, false},
        {new int[]{1, -1}, true},
        {new int[]{2, 3, -2}, true},
        {new int[]{0, 0}, true},
        {new int[]{5, 7, 9}, false},
        {new int[]{-5, -7, -9}, false},
        {new int[]{1, 2, 3, -3}, true},
        {new int[]{10, 20, -10, 30}, true},
        {new int[]{4, 5, 6, 7, 8}, false},
        {new int[]{0, 1, 2, 3, 4, 5, -5}, true}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[0][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[1][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[2][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[3][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[4][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[5][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[6][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[7][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[8][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_43_Source.pairsSumToZero((int[]) testCases[9][0]), 
                     new HumanEval_43_Transformed().checkForZeroSumPairs((int[]) testCases[9][0]));
    }
}