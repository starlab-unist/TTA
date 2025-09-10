import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_40 {

    // Source Code
    static class SourceCode {
        public static boolean triplesSumToZero(List<Integer> l) { // Made static
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    for (int k = j + 1; k < l.size(); k++) {
                        if (l.get(i) + l.get(j) + l.get(k) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean checkForZeroSumTriplets(int[] numbers) { // Made static
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
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, -3},          // Simple case with sum zero
        {-1, 0, 1},          // Another simple case with sum zero
        {1, 2, 3},           // No triplets sum to zero
        {0, 0, 0},           // All elements are zero
        {1, -1, 2, -2, 3},   // Multiple pairs but no triplet sums to zero
        {-5, 2, 3, 4, 1},    // Triplet (-5, 2, 3) sums to zero
        {-10, 1, 3, 6, 7},   // No triplet sums to zero
        {5, 5, 5, -15},      // Triplet (5, 5, -15) sums to zero
        {-2, 0, 2, 0},       // Multiple triplets with zeros and non-zeros
        {}                   // Empty list should return False
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void triplesSumToZero_vs_checkForZeroSumTriplets(Integer[] inputArray) {
        List<Integer> inputList = Arrays.asList(inputArray);
        int[] inputIntArray = Arrays.stream(inputArray).mapToInt(Integer::intValue).toArray();
        
        assertEquals(
            SourceCode.triplesSumToZero(inputList),
            TransformedCode.checkForZeroSumTriplets(inputIntArray)
        );
    }
}