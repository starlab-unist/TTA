import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_24 {

    // Source Code
    static class SourceCode {
        public int largestDivisor(int n) {
            for (int i = n - 1; i > 0; i--) {
                if (n % i == 0) {
                    return i;
                }
            }
            return 0; // In case no divisor is found, though for n > 0, this should not happen
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int findGreatestDivisor(int number) {
            int divisor = number - 1;
            while (divisor > 0) {
                if (number % divisor == 0) {
                    return divisor;
                }
                divisor--;
            }
            return 1; // In case no divisor is found, return 1 (though logically unreachable for number > 1)
        }
    }

    // Test Cases
    @DisplayName("Test largestDivisor and findGreatestDivisor methods")
    @ParameterizedTest(name = "Input: {0}, Expected Output: {1}")
    @CsvSource({
        "1, 0",       // Edge case: no divisors for 1 (original function will return 0)
        "2, 1",
        "3, 1",
        "4, 2",
        "5, 1",
        "6, 3",
        "10, 5",
        "15, 5",
        "20, 10",
        "25, 5",
        "8, 4",       // Simple test case
        "9, 3",       // Simple test case
        "12, 6",      // Simple test case
        "18, 9",      // Simple test case
        "21, 7"       // Simple test case
    })
    public void largestDivisor_vs_findGreatestDivisor(int input, int expectedOutput) {
        assertEquals(
            SourceCode.largestDivisor(input),
            TransformedCode.findGreatestDivisor(input),
            "Input: " + input + " should yield the same result in both functions"
        );
    }
}