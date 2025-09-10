import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_53 {

    // Source Code
    static class HumanEval_53_Source {
        public static int add(int x, int y) {
            return x + y;
        }
    }

    // Transformed Code
    static class HumanEval_53_Transformed {
        public static int computeSum(int a, int b) {
            int total = a + b;
            return total;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2},
        {-1, -1},
        {0, 0},
        {100, 200},
        {-50, 50},
        {123456789, 987654321},
        {0, 1},
        {10, -10},
        {999, 1},
        {1, 999}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void add_vs_computeSum(int x, int y) {
        assertEquals(
            HumanEval_53_Source.add(x, y),
            HumanEval_53_Transformed.computeSum(x, y)
        );
    }
}