// Import statements must be at the top of the file
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_40 {

    // Source Code
    static class HumanEval_40_Source {
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
    }

    // Transformed Code
    static class HumanEval_40_Transformed {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void triplesSumToZero_vs_check_for_zero_sum_triplets(int[] inputArray) {
        assertEquals(
            HumanEval_40_Source.triplesSumToZero(inputArray),
            HumanEval_40_Transformed.check_for_zero_sum_triplets(inputArray)
        );
    }
}