import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_108 {

    // Source Code
    public static int countNums(int[] arr) {
        return (int) Arrays.stream(arr)
                .map(HumanEval_108::digitsSum)
                .filter(x -> x > 0)
                .count();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String numStr = Integer.toString(n);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        digits[0] *= neg;
        return Arrays.stream(digits).sum();
    }

    // Transformed Code
    public static int tally_positive_digit_sums(int[] numbers) {
        int positive_sums_count = 0;

        for (int num : numbers) {
            if (compute_digit_sum(num) > 0) {
                positive_sums_count++;
            }
        }

        return positive_sums_count;
    }

    private static int compute_digit_sum(int number) {
        int sign = (number < 0) ? -1 : 1;
        int absolute_value = Math.abs(number);
        String digitStr = Integer.toString(absolute_value);
        int digitSum = 0;

        for (int i = 0; i < digitStr.length(); i++) {
            int digit = Character.getNumericValue(digitStr.charAt(i));
            if (i == 0) {
                digit *= sign;
            }
            digitSum += digit;
        }

        return digitSum;
    }

    // Test Cases
    private static final int[][] testCases = {
        {123, -456, 789}, 
        {-111, 222, -333, 444},
        {0, 0, 0},
        {-1, 1, -1, 1},
        {999, -888, 777, -666},
        {1001, 2002, -3003, 4004},
        {-5, 5, -5, 5, -5},
        {10, -20, 30, -40, 50},
        {987654321, -123456789},
        {-12345, 12345, -12345}
    };

    @Test
    public void test_0() {
        assertEquals(countNums(testCases[0]), tally_positive_digit_sums(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(countNums(testCases[1]), tally_positive_digit_sums(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(countNums(testCases[2]), tally_positive_digit_sums(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(countNums(testCases[3]), tally_positive_digit_sums(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(countNums(testCases[4]), tally_positive_digit_sums(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(countNums(testCases[5]), tally_positive_digit_sums(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(countNums(testCases[6]), tally_positive_digit_sums(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(countNums(testCases[7]), tally_positive_digit_sums(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(countNums(testCases[8]), tally_positive_digit_sums(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(countNums(testCases[9]), tally_positive_digit_sums(testCases[9]));
    }
}