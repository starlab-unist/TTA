import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Import Stream

public class HumanEval_163 {

    // Source Code
    static class SourceCode {
        public static List<Integer> generateIntegers(int a, int b) { // Make method static
            int lower = Math.max(2, Math.min(a, b));
            int upper = Math.min(8, Math.max(a, b));

            List<Integer> result = new ArrayList<>();
            for (int i = lower; i <= upper; i++) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> produceEvenNumbers(int x, int y) { // Make method static
            int start = Math.max(2, Math.min(x, y));
            int end = Math.min(8, Math.max(x, y));

            List<Integer> evenNumbers = new ArrayList<>();
            int current = start;
            while (current <= end) {
                if (current % 2 == 0) {
                    evenNumbers.add(current);
                }
                current++;
            }

            return evenNumbers;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 5},
        {3, 9},
        {6, 2},
        {8, 8},
        {0, 4},
        {7, 7},
        {2, 2},
        {10, 1},
        {5, 5},
        {4, 4}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing generateIntegers and produceEvenNumbers equivalence")
    void testGenerateIntegers_vs_produceEvenNumbers(int a, int b) {
        assertEquals(
            SourceCode.generateIntegers(a, b),
            TransformedCode.produceEvenNumbers(a, b)
        );
    }
}