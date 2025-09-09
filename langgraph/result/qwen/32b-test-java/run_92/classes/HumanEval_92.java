import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_92 {

    // Source Code
    static class SourceCode {
        public static boolean anyInt(int x, int y, int z) {
            if ((x + y == z) || (x + z == y) || (y + z == x)) {
                return true;
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkSumOfTwoEqualsThird(int a, int b, int c) {
            if (a + b == c || a + c == b || b + c == a) {
                return true;
            }
            return false;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3},
        {5, 3, 2},
        {4, 6, 10},
        {7, 3, 4},
        {1, 1, 2},
        {10, 5, 5},
        {0, 0, 0},
        {-1, -2, -3}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of anyInt and checkSumOfTwoEqualsThird")
    void testEquivalence(int x, int y, int z) {
        assertEquals(
            SourceCode.anyInt(x, y, z),
            new TransformedCode().checkSumOfTwoEqualsThird(x, y, z)
        );
    }
}