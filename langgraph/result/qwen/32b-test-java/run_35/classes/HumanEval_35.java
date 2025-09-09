import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_35 {

    // Source Code
    static class SourceCode {
        public static int maxElement(int[] l) {
            int m = l[0];
            for (int e : l) {
                if (e > m) {
                    m = e;
                }
            }
            return m;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int find_maximum_value(int[] elements) {
            int currentMax = elements[0];
            int index = 1;
            while (index < elements.length) {
                if (elements[index] > currentMax) {
                    currentMax = elements[index];
                }
                index++;
            }
            return currentMax;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5},
        {-7, -1, -5, -3, -9},
        {10, 20, 30, 40, 50},
        {100},
        {0, 0, 0, 0},
        {5, 5, 5, 5, 6},
        {-1, -2, -3, -4, -5, -6},
        {1},
        {2, 2, 2, 1, 1, 1},
        {9, 8, 7, 6, 5, 4, 3, 2, 1}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Test maxElement vs find_maximum_value")
    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void testMaxElementVsFindMaximumValue(int[] input) {
        assertEquals(
            SourceCode.maxElement(input),
            new TransformedCode().find_maximum_value(input)
        );
    }
}