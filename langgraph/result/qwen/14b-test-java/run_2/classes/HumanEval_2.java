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
        public static double truncateNumber(double number) {
            return number % 1.0;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static double extractDecimalPart(double value) {
            double decimalPart = value - (int)value;
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

    @ParameterizedTest(name = "Test case {index}: {0}")
    @MethodSource("provideTestCases")
    void truncateNumber_vs_extractDecimalPart(double input) {
        assertEquals(
            SourceCode.truncateNumber(input),
            TransformedCode.extractDecimalPart(input),
            1e-9 // delta for floating point comparison
        );
    }
}