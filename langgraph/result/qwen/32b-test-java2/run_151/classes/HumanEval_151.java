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
        int sum = 0;
        for (int i : lst) {
            if (i > 0 && i % 2 != 0) {
                sum += i * i;
            }
        }
        return sum;
    }

    // Transformed Code
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            if (num > 0 && num % 2 != 0) {
                total += num * num;
            }
        }
        return total;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5}},         // Mixed positive odd/even integers
        {Arrays.asList(-1, -3, -5, 0, 2, 4), new int[]{-1, -3, -5, 0, 2, 4}},   // Negative numbers and zero
        {Arrays.asList(7, 11, 13, 17), new int[]{7, 11, 13, 17}},         // Only positive odd integers
        {Arrays.asList(8, 10, 12, 14), new int[]{8, 10, 12, 14}},         // Only positive even integers
        {Arrays.asList(), new int[]{}},                                   // Empty list
        {Arrays.asList(1, 3, 5), new int[]{1, 3, 5}},                      // Mixed integers and floats (only integers considered)
        {Arrays.asList(21, 23, 25, 0, -27), new int[]{21, 23, 25, 0, -27}},// Positive odd integers with zero and negative
        {Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}}, // Descending order mixed odd/even integers
        {Arrays.asList(0), new int[]{0}}                                    // Single element zero
    };

    @Test
    public void test_0() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[0][0]), calculateModifiedSum((int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[1][0]), calculateModifiedSum((int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[2][0]), calculateModifiedSum((int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[3][0]), calculateModifiedSum((int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[4][0]), calculateModifiedSum((int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[5][0]), calculateModifiedSum((int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[6][0]), calculateModifiedSum((int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[7][0]), calculateModifiedSum((int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(doubleTheDifference((List<Integer>) testCases[8][0]), calculateModifiedSum((int[]) testCases[8][1]));
    }
}