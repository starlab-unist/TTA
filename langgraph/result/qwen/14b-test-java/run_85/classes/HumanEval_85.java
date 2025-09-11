import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_85 {

    // Source Code
    public static int add(int[] lst) {
        int sum = 0;
        for (int i = 1; i < lst.length; i += 2) {
            if (lst[i] % 2 == 0) {
                sum += lst[i];
            }
        }
        return sum;
    }

    // Transformed Code
    public static int calculateEvenSumAtOddIndices(int[] numbers) {
        int total = 0;
        int index = 1;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                total += numbers[index];
            }
            index += 2;
        }
        return total;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5, 6},       // Expected output: 6 (2 + 4)
        {10, 15, 20, 25, 30, 35}, // Expected output: 0 (no even numbers at odd indices)
        {2, 4, 6, 8, 10, 12},     // Expected output: 20 (4 + 8 + 12)
        {1, 3, 5, 7, 9},          // Expected output: 0 (no even numbers at odd indices)
        {},                       // Expected output: 0 (empty list)
        {0, 0, 0, 0, 0, 0},       // Expected output: 0 (all zeros)
        {1, 2},                   // Expected output: 2
        {1, 2, 3},                // Expected output: 2
        {1, 2, 3, 4},             // Expected output: 6 (2 + 4)
        {1, 2, 3, 4, 5}           // Expected output: 6 (2 + 4)
    };

    @Test
    public void test_0() {
        assertEquals(add(testCases[0]), calculateEvenSumAtOddIndices(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(add(testCases[1]), calculateEvenSumAtOddIndices(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(add(testCases[2]), calculateEvenSumAtOddIndices(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(add(testCases[3]), calculateEvenSumAtOddIndices(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(add(testCases[4]), calculateEvenSumAtOddIndices(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(add(testCases[5]), calculateEvenSumAtOddIndices(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(add(testCases[6]), calculateEvenSumAtOddIndices(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(add(testCases[7]), calculateEvenSumAtOddIndices(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(add(testCases[8]), calculateEvenSumAtOddIndices(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(add(testCases[9]), calculateEvenSumAtOddIndices(testCases[9]));
    }
}