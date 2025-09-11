import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_47 {

    // Source Code
    static class HumanEval_47_Source {
        public static double median(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            if (n % 2 == 1) {
                return arr[n / 2];
            } else {
                return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
            }
        }
    }

    // Transformed Code
    static class HumanEval_47_Transformed {
        public static double calculateMedian(int[] numbers) {
            Arrays.sort(numbers);
            int midIndex = numbers.length / 2;
            
            if (numbers.length % 2 == 1) {
                return numbers[midIndex];
            } else {
                return (numbers[midIndex - 1] + numbers[midIndex]) / 2.0;
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{3, 1, 2}, 2.0},
        {new int[]{4, 1, 3, 2}, 2.5},
        {new int[]{7}, 7.0},
        {new int[]{8, 9}, 8.5},
        {new int[]{10, 2, 5, 1, 8, 9, 3}, 5.0},
        {new int[]{5, 5, 5, 5, 5}, 5.0},
        {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5.5},
        {new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900, 1000}, 550.0},
        // Note: The test case [1.5, 2.5, 3.5] is not valid for int[] in Java
        {new int[]{-1, -2, -3, -4, -5}, -3.0}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[0][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[1][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[2][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[3][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[4][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[5][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[6][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[7][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[7][0]));
    }

    // Note: The test case [1.5, 2.5, 3.5] is not valid for int[] in Java
    @Test
    public void test_9() {
        assertEquals(HumanEval_47_Source.median((int[]) testCases[8][0]), 
                     HumanEval_47_Transformed.calculateMedian((int[]) testCases[8][0]));
    }
}