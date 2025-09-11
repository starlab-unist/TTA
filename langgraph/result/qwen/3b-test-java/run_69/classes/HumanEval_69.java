import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_69 {

    // Source Code
    public static int search(int[] lst) {
        int[] frq = new int[max(lst) + 1];
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

    private static int max(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Transformed Code
    public static int findMaxFrequencyIndex(int[] numbers) {
        int maxValue = 0;
        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }

        int[] frequencyArray = new int[maxValue + 1];
        for (int number : numbers) {
            frequencyArray[number]++;
        }

        int result = -1;
        int index = 1;
        while (index < frequencyArray.length) {
            if (frequencyArray[index] >= index) {
                result = index;
            }
            index++;
        }

        return result;
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
        assertEquals(search(testCases[0]), findMaxFrequencyIndex(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(search(testCases[1]), findMaxFrequencyIndex(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(search(testCases[2]), findMaxFrequencyIndex(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(search(testCases[3]), findMaxFrequencyIndex(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(search(testCases[4]), findMaxFrequencyIndex(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(search(testCases[5]), findMaxFrequencyIndex(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(search(testCases[6]), findMaxFrequencyIndex(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(search(testCases[7]), findMaxFrequencyIndex(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(search(testCases[8]), findMaxFrequencyIndex(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(search(testCases[9]), findMaxFrequencyIndex(testCases[9]));
    }
}