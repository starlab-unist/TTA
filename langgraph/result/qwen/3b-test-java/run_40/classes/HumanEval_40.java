import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_40 {

    // Source Code
    public static boolean triplesSumToZero(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = i + 1; j < l.length; j++) {
                for (int k = j + 1; k < l.length; k++) {
                    if (l[i] + l[j] + l[k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Transformed Code
    public static boolean checkForZeroSumTriplets(int[] numbers) {
        int length = numbers.length;
        int indexI = 0;

        while (indexI < length) {
            int indexJ = indexI + 1;
            while (indexJ < length) {
                int indexK = indexJ + 1;
                while (indexK < length) {
                    if (numbers[indexI] + numbers[indexJ] + numbers[indexK] == 0) {
                        return true;
                    }
                    indexK++;
                }
                indexJ++;
            }
            indexI++;
        }

        return false;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, -3},          // Simple case with sum zero
        {-1, 0, 1},          // Another simple case with sum zero
        {1, 2, 3},           // No triplets sum to zero
        {0, 0, 0},           // All elements are zero
        {1, -1, 2, -2, 3},   // Multiple pairs but no triplet sums to zero
        {-5, 2, 3, 4, 1},    // Triplet (-5, 2, 3) sums to zero
        {-10, 1, 3, 6, 7},   // Triplet (1, 3, -4) doesn't exist but others do not sum to zero
        {5, 5, 5, -15},      // Triplet (5, 5, -15) sums to zero
        {-2, 0, 2, 0},       // Multiple triplets with zeros and non-zeros
        {}                   // Empty list should return False
    };

    @Test
    public void test_0() {
        assertEquals(triplesSumToZero(testCases[0]), checkForZeroSumTriplets(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(triplesSumToZero(testCases[1]), checkForZeroSumTriplets(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(triplesSumToZero(testCases[2]), checkForZeroSumTriplets(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(triplesSumToZero(testCases[3]), checkForZeroSumTriplets(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(triplesSumToZero(testCases[4]), checkForZeroSumTriplets(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(triplesSumToZero(testCases[5]), checkForZeroSumTriplets(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(triplesSumToZero(testCases[6]), checkForZeroSumTriplets(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(triplesSumToZero(testCases[7]), checkForZeroSumTriplets(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(triplesSumToZero(testCases[8]), checkForZeroSumTriplets(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(triplesSumToZero(testCases[9]), checkForZeroSumTriplets(testCases[9]));
    }
}