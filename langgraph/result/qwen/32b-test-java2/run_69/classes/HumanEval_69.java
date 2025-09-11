import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_69 {

    // Source Code
    static class HumanEval_69_Source {
        public static int search(int[] lst) {
            int maxVal = 0;
            for (int num : lst) {
                if (num > maxVal) {
                    maxVal = num;
                }
            }

            int[] frq = new int[maxVal + 1];
            for (int i : lst) {
                frq[i]++;
            }

            int ans = -1;
            for (int i = 1; i < frq.length; i++) {
                if (frq[i] >= i) {
                    ans = i;
                }
            }

            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_69_Transformed {
        public int findMaxFrequencyIndex(int[] numbers) {
            int maxValue = 0;
            for (int number : numbers) {
                if (number > maxValue) {
                    maxValue = number;
                }
            }
            
            int[] frequencyArray = new int[maxValue + 1];
            
            for (int number : numbers) {
                frequencyArray[number] += 1;
            }

            int result = -1;
            int index = 1;
            while (index < frequencyArray.length) {
                if (frequencyArray[index] >= index) {
                    result = index;
                }
                index += 1;
            }

            return result;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 2, 3, 3, 3},
        {4, 5, 6, 7, 8, 9, 10},
        {1, 1, 1, 1, 1},
        {2, 2, 3, 3, 4, 4, 4, 4},
        {1, 2, 3, 4, 5},
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        {1, 1, 2, 2, 2, 3, 3, 3, 3},
        {5, 5, 5, 5, 5, 5},
        {1},
        {}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_69_Source.search(testCases[0]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_69_Source.search(testCases[1]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_69_Source.search(testCases[2]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_69_Source.search(testCases[3]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_69_Source.search(testCases[4]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_69_Source.search(testCases[5]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_69_Source.search(testCases[6]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_69_Source.search(testCases[7]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_69_Source.search(testCases[8]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_69_Source.search(testCases[9]), 
                     new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[9]));
    }
}