import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_84 {

    // Source Code
    public static String solve(int N) {
        int sum = 0;
        for (char c : Integer.toString(N).toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return Integer.toBinaryString(sum).substring(2);
    }

    // Transformed Code
    public static String convertToBinaryString(int number) {
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }
        String binaryRepresentation = Integer.toBinaryString(digitSum);
        return binaryRepresentation;
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        9,
        123,
        456,
        789,
        1001,
        11111111,
        987654321,
        (int) Math.pow(2, 10)
    };

    @Test
    public void test_0() {
        assertEquals(solve(testCases[0]), convertToBinaryString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(solve(testCases[1]), convertToBinaryString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(solve(testCases[2]), convertToBinaryString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(solve(testCases[3]), convertToBinaryString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(solve(testCases[4]), convertToBinaryString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(solve(testCases[5]), convertToBinaryString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(solve(testCases[6]), convertToBinaryString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(solve(testCases[7]), convertToBinaryString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(solve(testCases[8]), convertToBinaryString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(solve(testCases[9]), convertToBinaryString(testCases[9]));
    }
}