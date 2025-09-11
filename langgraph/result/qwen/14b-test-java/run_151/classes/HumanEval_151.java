import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_151 {

    // Source Code
    public static int doubleTheDifference(int[] lst) {
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
                total += Math.pow(num, 2);
            }
        }
        return total;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 4, 5}, 35},         // Mixed positive odd/even integers
        {new int[]{-1, -3, -5, 0, 2, 4}, 0},   // Negative numbers and zero
        {new int[]{7, 11, 13, 17}, 684},         // Only positive odd integers
        {new int[]{8, 10, 12, 14}, 0},         // Only positive even integers
        {new int[]{}, 0},                      // Empty list
        {new int[]{1, 3, 5}, 35},              // Mixed integers and floats (only integers considered)
        {new int[]{21, 23, 25, 0, -27}, 1464},  // Positive odd integers with zero and negative
        {new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 165}, // Descending order mixed odd/even integers
        {new int[]{0}, 0}                      // Single element zero
    };

    @Test
    public void test_0() {
        assertEquals(doubleTheDifference((int[]) testCases[0][0]), calculateModifiedSum((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(doubleTheDifference((int[]) testCases[1][0]), calculateModifiedSum((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(doubleTheDifference((int[]) testCases[2][0]), calculateModifiedSum((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(doubleTheDifference((int[]) testCases[3][0]), calculateModifiedSum((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(doubleTheDifference((int[]) testCases[4][0]), calculateModifiedSum((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(doubleTheDifference((int[]) testCases[5][0]), calculateModifiedSum((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(doubleTheDifference((int[]) testCases[6][0]), calculateModifiedSum((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(doubleTheDifference((int[]) testCases[7][0]), calculateModifiedSum((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(doubleTheDifference((int[]) testCases[8][0]), calculateModifiedSum((int[]) testCases[8][0]));
    }
}