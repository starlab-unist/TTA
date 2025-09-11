import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_142 {

    // Source Code
    public static int sumSquares(int[] lst) {
        int result = 0;
        for (int i = 0; i < lst.length; i++) {
            if (i % 3 == 0) {
                result += lst[i] * lst[i];
            } else if (i % 4 == 0 && i % 3 != 0) {
                result += lst[i] * lst[i] * lst[i];
            } else {
                result += lst[i];
            }
        }
        return result;
    }

    // Transformed Code
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            if (index % 3 == 0) {
                total += numbers[index] * numbers[index];
            } else if (index % 4 == 0) {
                total += numbers[index] * numbers[index] * numbers[index];
            }
            index++;
        }
        return total;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},          // Simple list with small integers
        {0, 0, 0, 0, 0},          // List of zeros
        {1, 1, 1, 1, 1},          // List of ones
        {-1, -2, -3, -4, -5},     // Simple list with negative integers
        {10, 20, 30, 40, 50},     // List of larger integers
        {9, 8, 7, 6, 5},          // Decreasing list of integers
        {1, -1, 1, -1, 1},        // Alternating positive and negative integers
        {},                       // Empty list
        {2, 3, 4, 5, 6, 7, 8},    // Simple list with small integers
        {5, 0, 10, 0, 15}         // List containing zeros
    };

    @Test
    public void test_0() {
        assertEquals(sumSquares(testCases[0]), calculateModifiedSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(sumSquares(testCases[1]), calculateModifiedSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(sumSquares(testCases[2]), calculateModifiedSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(sumSquares(testCases[3]), calculateModifiedSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(sumSquares(testCases[4]), calculateModifiedSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(sumSquares(testCases[5]), calculateModifiedSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(sumSquares(testCases[6]), calculateModifiedSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(sumSquares(testCases[7]), calculateModifiedSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(sumSquares(testCases[8]), calculateModifiedSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(sumSquares(testCases[9]), calculateModifiedSum(testCases[9]));
    }
}