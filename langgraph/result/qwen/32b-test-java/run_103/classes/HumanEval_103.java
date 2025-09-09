import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_103 {

    // Source Code
    static class HumanEval_103 {
        public static String roundedAvg(int n, int m) {
            if (m < n) {
                return "-1";
            }
            int summation = 0;
            for (int i = n; i <= m; i++) {
                summation += i;
            }
            int average = Math.round((float) summation / (m - n + 1));
            return Integer.toBinaryString(average);
        }
    }

    // Transformed Code
    static class HumanEval_103_Transformed {
        public String calculateBinaryAverage(int start, int end) {
            if (end < start) {
                return "-1";
            }
            int totalSum = 0;
            int current = start;
            while (current <= end) {
                totalSum += current;
                current += 1;
            }
            int average = Math.round((float) totalSum / (end - start + 1));
            return Integer.toBinaryString(average);
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(1, 5),       // Simple range
        Arguments.of(0, 0),       // Single element range
        Arguments.of(-2, 2),      // Range with negative numbers
        Arguments.of(10, 10),     // Single element range at higher number
        Arguments.of(5, 1),       // Invalid range where end < start
        Arguments.of(-5, -1),     // Negative range
        Arguments.of(1, 100),     // Larger range
        Arguments.of(10, 20),     // Another simple range
        Arguments.of(20, 30),     // Another simple range
        Arguments.of(100, 200)    // Larger range
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest(name = "Test with inputs {0} and {1}")
    @MethodSource("provideTestCases")
    void roundedAvg_vs_calculateBinaryAverage(int n, int m) {
        assertEquals(
            HumanEval_103.roundedAvg(n, m),
            new HumanEval_103_Transformed().calculateBinaryAverage(n, m)
        );
    }
}