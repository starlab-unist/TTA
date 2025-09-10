import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Add this import
import java.util.stream.Stream;  // Add this import

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
    private static final Arguments[] testCases = {
        Arguments.of(1, 2, 3),   // True: 1 + 2 == 3
        Arguments.of(5, 3, 2),   // True: 3 + 2 == 5
        Arguments.of(4, 6, 10),  // True: 4 + 6 == 10
        Arguments.of(7, 3, 4),   // True: 3 + 4 == 7
        Arguments.of(1, 1, 2),   // True: 1 + 1 == 2
        Arguments.of(10, 5, 5),  // False: No two numbers sum to the third
        Arguments.of(0, 0, 0),   // True: 0 + 0 == 0
        Arguments.of(-1, -2, -3) // True: -1 + -2 == -3
    };

    private static final Arguments[] additionalTestCases = {
        Arguments.of(2, 2, 4),   // True: 2 + 2 == 4
        Arguments.of(3, 3, 6),   // True: 3 + 3 == 6
        Arguments.of(9, 1, 8),   // False: No two numbers sum to the third (corrected from original)
        Arguments.of(5, 5, 10),  // True: 5 + 5 == 10
        Arguments.of(2, 3, 6)    // False: No two numbers sum to the third
    };

    private static Stream<Arguments> provideTestCases() {
        return Stream.concat(Arrays.stream(testCases), Arrays.stream(additionalTestCases));
    }

    @ParameterizedTest(name = "Test case {index}: anyInt({arguments})")
    @MethodSource("provideTestCases")
    void anyInt_vs_checkSumOfTwoEqualsThird(int x, int y, int z) {
        assertEquals(
            SourceCode.anyInt(x, y, z),
            new TransformedCode().checkSumOfTwoEqualsThird(x, y, z)
        );
    }
}