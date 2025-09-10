import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_24 {

    // Source Code
    static class SourceCode {
        public int largestDivisor(int n) {  // Instance method
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
        public int findGreatestDivisor(int number) {  // Instance method
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
    @ParameterizedTest
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
        "25, 5"
    })
    @DisplayName("Check if largestDivisor and findGreatestDivisor produce the same output")
    void testLargestDivisor_vs_findGreatestDivisor(int inputNumber, int expectedOutput) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.largestDivisor(inputNumber),
            transformed.findGreatestDivisor(inputNumber)
        );
    }
}