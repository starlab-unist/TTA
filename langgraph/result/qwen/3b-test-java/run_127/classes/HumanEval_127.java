import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_127 {

    // Source Code
    public static String intersection(int[] interval1, int[] interval2) {
        int l = Math.max(interval1[0], interval2[0]);
        int r = Math.min(interval1[1], interval2[1]);
        int length = r - l;

        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Transformed Code
    public static String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        int start = Math.max(range1[0], range2[0]);
        int end = Math.min(range1[1], range2[1]);
        int length = end - start;

        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    // Test Cases
    private static final int[][][] testCases = {
        {{1, 5}, {3, 7}},   // Overlapping interval with prime length 2
        {{10, 20}, {15, 25}}, // Overlapping interval with non-prime length 5
        {{5, 5}, {5, 5}},     // No overlap
        {{2, 3}, {3, 4}},     // No overlap
        {{0, 1}, {1, 2}},     // No overlap
        {{1, 10}, {5, 6}},    // Overlapping interval with prime length 1
        {{1, 11}, {5, 7}},    // Overlapping interval with non-prime length 2
        {{4, 9}, {8, 13}},    // Overlapping interval with prime length 1
        {{1, 20}, {5, 15}},   // Overlapping interval with non-prime length 10
        {{7, 11}, {9, 13}}    // Overlapping interval with prime length 2
    };

    @Test
    public void test_0() {
        assertEquals(intersection(testCases[0][0], testCases[0][1]), 
                     checkIntervalForPrimeLength(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(intersection(testCases[1][0], testCases[1][1]), 
                     checkIntervalForPrimeLength(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(intersection(testCases[2][0], testCases[2][1]), 
                     checkIntervalForPrimeLength(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(intersection(testCases[3][0], testCases[3][1]), 
                     checkIntervalForPrimeLength(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(intersection(testCases[4][0], testCases[4][1]), 
                     checkIntervalForPrimeLength(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(intersection(testCases[5][0], testCases[5][1]), 
                     checkIntervalForPrimeLength(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(intersection(testCases[6][0], testCases[6][1]), 
                     checkIntervalForPrimeLength(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(intersection(testCases[7][0], testCases[7][1]), 
                     checkIntervalForPrimeLength(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(intersection(testCases[8][0], testCases[8][1]), 
                     checkIntervalForPrimeLength(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(intersection(testCases[9][0], testCases[9][1]), 
                     checkIntervalForPrimeLength(testCases[9][0], testCases[9][1]));
    }
}