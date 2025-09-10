import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_103 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
    private static final int[][] testCases = {
        {1, 5},       // Simple range
        {0, 0},       // Single element range
        {-2, 2},      // Range with negative numbers
        {10, 10},     // Single element range at higher number
        {5, 1},       // Invalid range where end < start
        {-5, -1},     // Negative range
        {1, 100},     // Larger range
        {10, 20},     // Another simple range
        {20, 30},     // Another simple range
        {100, 200}    // Larger range
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void roundedAvg_vs_calculateBinaryAverage(int n, int m) {
        assertEquals(
            SourceCode.roundedAvg(n, m),
            new TransformedCode().calculateBinaryAverage(n, m)
        );
    }
}