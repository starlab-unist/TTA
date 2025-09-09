import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HumanEval_83 {

    // Source Code Class
    static class HumanEval_83 {
        public int startsOneEnds(int n) {
            if (n == 1) return 1;
            return 18 * (int) Math.pow(10, n - 2);
        }
    }

    // Transformed Code Class
    static class HumanEval_83_Transformed {
        public int calculateSpecialNumber(int length) {
            if (length == 1) {
                return 1;
            }
            int multiplier = 18;
            int base = (int) Math.pow(10, length - 2);
            return multiplier * base;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "Test case {index} with input {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void testEquivalence(int input) {
        HumanEval_83 sourceCode = new HumanEval_83();
        HumanEval_83_Transformed transformedCode = new HumanEval_83_Transformed();

        assertEquals(
            sourceCode.startsOneEnds(input),
            transformedCode.calculateSpecialNumber(input)
        );
    }
}