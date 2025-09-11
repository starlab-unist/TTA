import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_151 {

    // Source Code
    public static int doubleTheDifference(List<Integer> lst) {
        return lst.stream()
                    .filter(i -> i > 0 && i % 2 != 0 && !str(i).contains("."))
                    .mapToInt(i -> i * i)
                    .sum();
    }

    private static String str(int i) {
        return Integer.toString(i);
    }

    // Transformed Code
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            if (num > 0 && num % 2 != 0) { // Removed unnecessary 'instanceof Integer' check
                total += num * num;
            }
        }
        return total;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},         // Mixed positive odd/even integers
        {-1, -3, -5, 0, 2, 4},   // Negative numbers and zero
        {7, 11, 13, 17},         // Only positive odd integers
        {8, 10, 12, 14},         // Only positive even integers
        {},                      // Empty list
        {1, 3, 5},               // Mixed integers and floats (filtered to integers)
        {21, 23, 25, 0, -27},    // Positive odd integers with zero and negative
        {9, 8, 7, 6, 5, 4, 3, 2, 1}, // Descending order mixed odd/even integers
        {0}                      // Single element zero
    };

    @Test
    public void test_0() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[0]).boxed().toList()), calculateModifiedSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[1]).boxed().toList()), calculateModifiedSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[2]).boxed().toList()), calculateModifiedSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[3]).boxed().toList()), calculateModifiedSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[4]).boxed().toList()), calculateModifiedSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[5]).boxed().toList()), calculateModifiedSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[6]).boxed().toList()), calculateModifiedSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[7]).boxed().toList()), calculateModifiedSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(doubleTheDifference(Arrays.stream(testCases[8]).boxed().toList()), calculateModifiedSum(testCases[8]));
    }
}