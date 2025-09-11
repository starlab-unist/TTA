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
        List<Integer> filteredList = Arrays.stream(arr)
            .map(HumanEval_108::digitsSum)
            .filter(x -> x > 0)
            .boxed()
            .collect(Collectors.toList());
        return filteredList.size();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n *= -1;
            neg = -1;
        }
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum * neg;
    }

    // Transformed Code
    public static int tallyPositiveDigitSums(int[] numbers) {
        int positiveSumsCount = 0;
        for (int num : numbers) {
            if (computeDigitSum(num) > 0) {
                positiveSumsCount++;
            }
        }
        return positiveSumsCount;
    }

    private static int computeDigitSum(int number) {
        int sign = number < 0 ? -1 : 1;
        int absoluteValue = Math.abs(number);
        String numberStr = Integer.toString(absoluteValue);
        int digitSum = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            int digit = Character.digit(numberStr.charAt(i), 10);
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
        assertEquals(countNums(testCases[0]), tallyPositiveDigitSums(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(countNums(testCases[1]), tallyPositiveDigitSums(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(countNums(testCases[2]), tallyPositiveDigitSums(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(countNums(testCases[3]), tallyPositiveDigitSums(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(countNums(testCases[4]), tallyPositiveDigitSums(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(countNums(testCases[5]), tallyPositiveDigitSums(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(countNums(testCases[6]), tallyPositiveDigitSums(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(countNums(testCases[7]), tallyPositiveDigitSums(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(countNums(testCases[8]), tallyPositiveDigitSums(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(countNums(testCases[9]), tallyPositiveDigitSums(testCases[9]));
    }
}