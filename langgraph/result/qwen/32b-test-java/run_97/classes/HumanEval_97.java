import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_97 {

    // Source Code
    static class SourceCode {
        public int multiply(int a, int b) {
            return Math.abs(a % 10) * Math.abs(b % 10);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateUnitDigitProduct(int x, int y) {
            int unitDigitX = Math.abs(x % 10);
            int unitDigitY = Math.abs(y % 10);
            int product = unitDigitX * unitDigitY;
            return product;
        }
    }

    // Test Cases
    @DisplayName("Test Equivalence of multiply and calculateUnitDigitProduct")
    @ParameterizedTest(name = "SourceCode.multiply({0}, {1}) == TransformedCode.calculateUnitDigitProduct({0}, {1})")
    @CsvSource({
        "123, 456",   // Both positive
        "-123, 456",  // One negative, one positive
        "123, -456",  // One positive, one negative
        "-123, -456", // Both negative
        "0, 456",     // First is zero
        "123, 0",     // Second is zero
        "0, 0",       // Both are zero
        "789, 12345", // Larger numbers
        "5, 9",       // Single digits
        "10, 10"      // Multiples of ten
    })
    void testMultiply_vs_calculateUnitDigitProduct(int a, int b) {
        assertEquals(
            SourceCode.multiply(a, b),
            TransformedCode.calculateUnitDigitProduct(a, b)
        );
    }
}