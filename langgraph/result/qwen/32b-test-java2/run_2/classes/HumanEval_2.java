import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_2 {

    // Source Code
    static class SourceCode {
        public static float truncateNumber(float number) {
            return number % 1.0f;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static double extractDecimalPart(double value) {
            double decimalPart = value - (int) value;
            return decimalPart;
        }
    }

    // Test Cases
    private static final Double[] testCases = {
        3.14159,
        0.99999,
        123.456,
        -789.123,
        0.0,
        -0.0,
        100.0,
        -100.0,
        1.0,
        -1.0
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of truncateNumber and extractDecimalPart")
    void testTruncateNumber_vs_ExtractDecimalPart(double input) {
        assertEquals(
            SourceCode.truncateNumber((float) input),
            TransformedCode.extractDecimalPart(input),
            0.0001 // delta for floating-point comparison
        );
    }
}