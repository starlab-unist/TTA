import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_2 {

    // Source Code Method
    public static float truncateNumber(float number) {
        return number % 1.0f;
    }

    // Transformed Code Method
    public static double extractDecimalPart(double value) {
        double decimalPart = value - (int) value;
        return decimalPart;
    }

    // Test Inputs
    private static final double[] testCases = {
        3.75,      // Simple fractional part
        -2.25,     // Negative number with fractional part
        0.0,       // Zero
        -0.0,      // Negative zero (edge case)
        10.0,      // Integer value
        -10.0,     // Negative integer value
        0.9999,    // Fractional part close to 1
        1.0001,    // Fractional part slightly more than 1 (edge case)
        5.5,       // Simple fractional part with positive integer
        -3.5       // Simple fractional part with negative integer
    };

    @ParameterizedTest(name = "Test case {index}: {0}")
    @ValueSource(doubles = testCases)
    public void truncateNumber_vs_extractDecimalPart(double inputValue) {
        float sourceResult = truncateNumber((float) inputValue);
        double transformedResult = extractDecimalPart(inputValue);

        // Compare results with a delta to handle floating-point precision issues
        assertEquals(sourceResult, (float)transformedResult, 0.0001f, "The results from both methods should be equal for input: " + inputValue);
    }
}