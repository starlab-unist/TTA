import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_144 {

    // Source Code
    static class HumanEval_144 {
        public static boolean simplify(String x, String n) {
            String[] fraction1 = x.split("/");
            String[] fraction2 = n.split("/");
            int numerator = Integer.parseInt(fraction1[0]) * Integer.parseInt(fraction2[0]);
            int denom = Integer.parseInt(fraction1[1]) * Integer.parseInt(fraction2[1]);
            return (numerator / (double) denom == Math.floor(numerator / (double) denom));
        }
    }

    // Transformed Code
    static class HumanEval_144_Transformed {
        public static boolean checkFractionSimplification(String fraction1, String fraction2) {
            String[] parts1 = fraction1.split("/");
            String[] parts2 = fraction2.split("/");
            int num1 = Integer.parseInt(parts1[0]);
            int denom1 = Integer.parseInt(parts1[1]);
            int num2 = Integer.parseInt(parts2[0]);
            int denom2 = Integer.parseInt(parts2[1]);
            int resultNumerator = num1 * num2;
            int resultDenominator = denom1 * denom2;
            return resultNumerator % resultDenominator == 0;
        }
    }

    @DisplayName("Test Fraction Simplification Equivalence")
    @ParameterizedTest(name = "Test case {index}: ({arguments})")
    @CsvSource({
        "'1/2', '2/4'",
        "'3/4', '4/8'",
        "'5/6', '2/3'",
        "'7/9', '9/18'",
        "'1/1', '1/1'",
        "'0/1', '5/10'",
        "'2/3', '3/6'",
        "'10/20', '20/40'",
        "'1/3', '3/9'",
        "'5/7', '7/14'"
    })
    void testSimplifyVsCheckFractionSimplification(String fraction1, String fraction2) {
        assertEquals(
            HumanEval_144.simplify(fraction1, fraction2),
            HumanEval_144_Transformed.checkFractionSimplification(fraction1, fraction2)
        );
    }
}