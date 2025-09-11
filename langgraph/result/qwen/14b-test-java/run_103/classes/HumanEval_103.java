import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_103 {

    // Source Code
    public static String roundedAvg(int n, int m) {
        if (m < n) {
            return "-1";
        }
        int summation = 0;
        for (int i = n; i <= m; i++) {
            summation += i;
        }
        return Integer.toBinaryString((int) Math.round((double) summation / (m - n + 1)));
    }

    // Transformed Code
    public static String calculateBinaryAverage(int start, int end) {
        if (end < start) {
            return "-1";
        }
        int totalSum = 0;
        int current = start;
        while (current <= end) {
            totalSum += current;
            current += 1;
        }
        int average = Math.round((float) totalSum / (end - start + 1));
        return Integer.toBinaryString(average);
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 5},       // Simple range
        {0, 0},       // Single element range
        {-2, 2},      // Range with negative numbers
        {10, 10},     // Single element range at higher number
        {5, 1},       // Invalid range where end < start
        {-5, -1},     // Negative range
        {1, 100},     // Larger range
        {10, 20},     // Another simple range
        {20, 30},     // Another simple range
        {100, 200}    // Larger range
    };

    @Test
    public void test_0() {
        assertEquals(roundedAvg((int) testCases[0][0], (int) testCases[0][1]), 
                     calculateBinaryAverage((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(roundedAvg((int) testCases[1][0], (int) testCases[1][1]), 
                     calculateBinaryAverage((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(roundedAvg((int) testCases[2][0], (int) testCases[2][1]), 
                     calculateBinaryAverage((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(roundedAvg((int) testCases[3][0], (int) testCases[3][1]), 
                     calculateBinaryAverage((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(roundedAvg((int) testCases[4][0], (int) testCases[4][1]), 
                     calculateBinaryAverage((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(roundedAvg((int) testCases[5][0], (int) testCases[5][1]), 
                     calculateBinaryAverage((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(roundedAvg((int) testCases[6][0], (int) testCases[6][1]), 
                     calculateBinaryAverage((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(roundedAvg((int) testCases[7][0], (int) testCases[7][1]), 
                     calculateBinaryAverage((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(roundedAvg((int) testCases[8][0], (int) testCases[8][1]), 
                     calculateBinaryAverage((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(roundedAvg((int) testCases[9][0], (int) testCases[9][1]), 
                     calculateBinaryAverage((int) testCases[9][0], (int) testCases[9][1]));
    }
}