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
    static class HumanEval_103_Source {
        public static String roundedAvg(int n, int m) {
            if (m < n) {
                return "-1";
            }
            
            int summation = 0;
            for (int i = n; i <= m; i++) {
                summation += i;
            }
            
            int average = summation / (m - n + 1);
            return Integer.toBinaryString(average);
        }
    }

    // Transformed Code
    static class HumanEval_103_Transformed {
        public static String calculateBinaryAverage(int start, int end) {
            if (end < start) {
                return "-1";
            }
            
            int totalSum = 0;
            int current = start;
            
            // Calculate the sum of numbers from start to end
            while (current <= end) {
                totalSum += current;
                current++;
            }
            
            // Calculate the average and round it
            int average = (int) Math.round((double) totalSum / (end - start + 1));
            
            // Convert the average to binary
            return Integer.toBinaryString(average);
        }
    }

    // Test Cases
    private static final int[][] testCases = {
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
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[0][0], testCases[0][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[1][0], testCases[1][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[2][0], testCases[2][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[3][0], testCases[3][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[4][0], testCases[4][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[5][0], testCases[5][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[6][0], testCases[6][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[7][0], testCases[7][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[8][0], testCases[8][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_103_Source.roundedAvg(testCases[9][0], testCases[9][1]), 
                     HumanEval_103_Transformed.calculateBinaryAverage(testCases[9][0], testCases[9][1]));
    }
}