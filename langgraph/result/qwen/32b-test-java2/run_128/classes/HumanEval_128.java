// Source Code
class SourceCode {
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        int countNegatives = 0;
        int sumOfAbsValues = 0;
        boolean containsZero = false;

        for (int num : arr) {
            if (num == 0) {
                containsZero = true;
            }
            if (num < 0) {
                countNegatives++;
            }
            sumOfAbsValues += Math.abs(num);
        }

        int prod = containsZero ? 0 : (countNegatives % 2 == 0) ? 1 : -1;
        return prod * sumOfAbsValues;
    }
}

// Transformed Code
class TransformedCode {
    public static Integer calculateSignedSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int negativeCount = 0;
        boolean containsZero = false;

        for (int num : numbers) {
            if (num < 0) {
                negativeCount++;
            }
            if (num == 0) {
                containsZero = true;
            }
        }

        int sign = containsZero ? 0 : (negativeCount % 2 == 0) ? 1 : -1;
        int totalSum = 0;

        for (int num : numbers) {
            totalSum += Math.abs(num);
        }

        return sign * totalSum;
    }
}

// Test Cases
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays; // Added import for Arrays class
import java.util.stream.Stream;

public class HumanEval_128 {

    private static final int[][] testCases = {
        {1, 2, 3},
        {-1, -2, -3},
        {1, -2, 3},
        {0, 1, 2, 3},
        {0, -1, -2, -3},
        {},
        {5, 7, -9, 12},
        {-5, -7, 9, -12},
        {0, 0, 0},
        {1, 1, 1, -1, -1, -1}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test prodSigns vs calculateSignedSum")
    void prodSigns_vs_calculateSignedSum(int[] inputArray) {
        assertEquals(
            SourceCode.prodSigns(inputArray),
            TransformedCode.calculateSignedSum(inputArray)
        );
    }
}