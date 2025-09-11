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
    public static boolean check_for_zero_sum_triplets(int[] numbers) {
        int length = numbers.length;
        int index_i = 0;

        while (index_i < length) {
            int index_j = index_i + 1;
            while (index_j < length) {
                int index_k = index_j + 1;
                while (index_k < length) {
                    if (numbers[index_i] + numbers[index_j] + numbers[index_k] == 0) {
                        return true;
                    }
                    index_k += 1;
                }
                index_j += 1;
            }
            index_i += 1;
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
        assertEquals(triplesSumToZero(testCases[0]), check_for_zero_sum_triplets(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(triplesSumToZero(testCases[1]), check_for_zero_sum_triplets(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(triplesSumToZero(testCases[2]), check_for_zero_sum_triplets(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(triplesSumToZero(testCases[3]), check_for_zero_sum_triplets(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(triplesSumToZero(testCases[4]), check_for_zero_sum_triplets(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(triplesSumToZero(testCases[5]), check_for_zero_sum_triplets(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(triplesSumToZero(testCases[6]), check_for_zero_sum_triplets(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(triplesSumToZero(testCases[7]), check_for_zero_sum_triplets(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(triplesSumToZero(testCases[8]), check_for_zero_sum_triplets(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(triplesSumToZero(testCases[9]), check_for_zero_sum_triplets(testCases[9]));
    }
}