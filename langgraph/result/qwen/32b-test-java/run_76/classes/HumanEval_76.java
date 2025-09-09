import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_76 {

    // Source Code
    static class SourceCode {
        public boolean isSimplePower(int x, int n) {
            if (n == 1) {
                return x == 1;
            }
            int power = 1;
            while (power < x) {
                power *= n;
            }
            return power == x;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkPowerRelation(int base, int exponent) {
            if (exponent == 1) {
                return base == 1;
            }
            
            int currentValue = 1;
            while (currentValue < base) {
                currentValue *= exponent;
            }
            
            return currentValue == base;
        }
    }

    // Test Cases
    @ParameterizedTest
    @CsvSource({
            "1, 1",   // x^n = 1^1 = 1
            "8, 2",   // x^n = 2^3 = 8
            "9, 3",   // x^n = 3^2 = 9
            "27, 3",  // x^n = 3^3 = 27
            "16, 4",  // x^n = 4^2 = 16
            "10, 10", // x^n = 10^1 = 10
            "256, 2", // x^n = 2^8 = 256
            "1, 5",   // x^n = 1^5 = 1
            "0, 2",   // x^n is not possible for 0 with n > 0 in this context
            "7, 3"    // 7 is not a power of 3
            "4, 2",   // x^n = 2^2 = 4
            "100, 10",// x^n = 10^2 = 100 (should be false)
            "64, 4",  // x^n = 4^3 = 64
            "81, 9",  // x^n = 9^2 = 81
            "1, 0"    // Special case: 1 to any power is 1, but n=0 should be handled carefully if defined.
    })
    @DisplayName("Test Equivalence between Source and Transformed Code")
    void testEquivalence(int x, int n) {
        assertEquals(
                SourceCode.isSimplePower(x, n),
                TransformedCode.checkPowerRelation(x, n)
        );
    }
}