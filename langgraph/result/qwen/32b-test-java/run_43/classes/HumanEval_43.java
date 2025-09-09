import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_43 {

    // Source Code
    static class SourceCode {
        public static boolean pairsSumToZero(int[] l) {
            for (int i = 0; i < l.length; i++) {
                for (int j = i + 1; j < l.length; j++) {
                    if (l[i] + l[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkForZeroSumPairs(int[] numbers) {
            int index = 0;
            while (index < numbers.length) {
                int currentNumber = numbers[index];
                int nextIndex = index + 1;
                while (nextIndex < numbers.length) {
                    if (currentNumber + numbers[nextIndex] == 0) {
                        return true;
                    }
                    nextIndex++;
                }
                index++;
            }
            return false;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {},
        {1, -1},
        {2, 3, -2},
        {0, 0},
        {5, 7, 9},
        {-5, -7, -9},
        {1, 2, 3, -3},
        {10, 20, -10, 30},
        {4, 5, 6, 7, 8},
        {0, 1, 2, 3, 4, 5, -5}
    };

    private static final boolean[] expectedResults = {
        false,
        true,
        true,
        true,
        false,
        false,
        true,
        true,
        false,
        true
    };

    private static int[][] provideTestCases() {
        return testCases;
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void pairsSumToZero_vs_checkForZeroSumPairs(int[] input) {
        assertEquals(
            SourceCode.pairsSumToZero(input),
            TransformedCode.checkForZeroSumPairs(input)
        );
    }
}