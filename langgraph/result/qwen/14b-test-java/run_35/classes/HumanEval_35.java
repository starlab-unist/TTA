import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

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
        public static int find_maximum_value(int[] elements) {
            int current_max = elements[0];
            int index = 1;
            while (index < elements.length) {
                if (elements[index] > current_max) {
                    current_max = elements[index];
                }
                index += 1;
            }
            return current_max;
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

    @DisplayName("Source Code vs Transformed Code Comparison")
    @ParameterizedTest(name = "Test Case {index}: {0}")
    @MethodSource("provideTestCases")
    void maxElement_vs_find_maximum_value(int[] inputArray) {
        assertEquals(
            SourceCode.maxElement(inputArray),
            TransformedCode.find_maximum_value(inputArray)
        );
    }
}