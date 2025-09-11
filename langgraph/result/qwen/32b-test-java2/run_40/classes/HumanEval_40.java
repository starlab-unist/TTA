import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Original Implementation
class OriginalImpl {
    public static boolean triplesSumToZero(List<Integer> l) {
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

// Transformed Implementation
class TransformedImpl {
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
}

// Test Class
public class HumanEval_40 {

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 2, -3)),          // Simple case with sum zero
            Arguments.of(List.of(-1, 0, 1)),          // Another simple case with sum zero
            Arguments.of(List.of(1, 2, 3)),           // No triplets sum to zero
            Arguments.of(List.of(0, 0, 0)),           // All elements are zero
            Arguments.of(List.of(1, -1, 2, -2, 3)),   // Multiple pairs but no triplet sums to zero
            Arguments.of(List.of(-5, 2, 3, 4, 1)),    // Triplet (-5, 2, 3) sums to zero
            Arguments.of(List.of(-10, 1, 3, 6, 7)),   // Triplet (1, 3, -4) doesn't exist but others do not sum to zero
            Arguments.of(List.of(5, 5, 5, -15)),      // Triplet (5, 5, -15) sums to zero
            Arguments.of(List.of(-2, 0, 2, 0)),       // Multiple triplets with zeros and non-zeros
            Arguments.of(List.of())                    // Empty list should return False
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testTriplesSumToZero(List<Integer> input) {
        boolean originalResult = OriginalImpl.triplesSumToZero(input);
        boolean transformedResult = TransformedImpl.checkForZeroSumTriplets(input.stream().mapToInt(Integer::intValue).toArray());

        assertEquals(originalResult, transformedResult);
    }
}