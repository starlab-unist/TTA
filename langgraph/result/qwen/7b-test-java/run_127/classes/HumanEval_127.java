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
        boolean isPrime(int num) {
            if (num == 1 || num == 0) {
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

        int l = Math.max(interval1[0], interval2[0]);
        int r = Math.min(interval1[1], interval2[1]);
        int length = r - l;
        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    // Transformed Code
    public static String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        boolean isPrime(int number) {
            if (number == 0 || number == 1) {
                return false;
            }
            if (number == 2) {
                return true;
            }
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        int l = Math.max(range1[0], range2[0]);
        int r = Math.min(range1[1], range2[1]);
        int length = r - l;
        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 5}, new int[]{3, 7}},   // Overlapping interval with prime length 2
        {new int[]{10, 20}, new int[]{15, 25}}, // Overlapping interval with non-prime length 5
        {new int[]{5, 5}, new int[]{5, 5}},     // No overlap
        {new int[]{2, 3}, new int[]{3, 4}},     // No overlap
        {new int[]{0, 1}, new int[]{1, 2}},     // No overlap
        {new int[]{1, 10}, new int[]{5, 6}},    // Overlapping interval with prime length 1
        {new int[]{1, 11}, new int[]{5, 7}},    // Overlapping interval with non-prime length 2
        {new int[]{4, 9}, new int[]{8, 13}},    // Overlapping interval with prime length 1
        {new int[]{1, 20}, new int[]{5, 15}},   // Overlapping interval with non-prime length 10
        {new int[]{7, 11}, new int[]{9, 13}}    // Overlapping interval with prime length 2
    };

    @Test
    public void test_0() {
        assertEquals(intersection((int[]) testCases[0][0], (int[]) testCases[0][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[0][0], (int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(intersection((int[]) testCases[1][0], (int[]) testCases[1][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[1][0], (int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(intersection((int[]) testCases[2][0], (int[]) testCases[2][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[2][0], (int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(intersection((int[]) testCases[3][0], (int[]) testCases[3][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[3][0], (int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(intersection((int[]) testCases[4][0], (int[]) testCases[4][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[4][0], (int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(intersection((int[]) testCases[5][0], (int[]) testCases[5][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[5][0], (int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(intersection((int[]) testCases[6][0], (int[]) testCases[6][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[6][0], (int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(intersection((int[]) testCases[7][0], (int[]) testCases[7][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[7][0], (int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(intersection((int[]) testCases[8][0], (int[]) testCases[8][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[8][0], (int[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(intersection((int[]) testCases[9][0], (int[]) testCases[9][1]), 
                     checkIntervalForPrimeLength((int[]) testCases[9][0], (int[]) testCases[9][1]));
    }
}