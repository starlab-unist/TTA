import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_15 {

    // Source Code
    static class SourceCode {
        public String stringSequence(int n) {
            StringBuilder result = new StringBuilder();
            for (int x = 0; x <= n; x++) {
                result.append(x);
                if (x < n) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String generateNumberSeries(int length) {
            StringBuilder numberList = new StringBuilder();
            int index = 0;

            while (index <= length) {
                numberList.append(index);
                if (index < length) {
                    numberList.append(" ");
                }
                index++;
            }

            return numberList.toString();
        }
    }

    // Test Cases
    private static final int[] testCases = {0, 1, 5, 10, 20, 100, -1, 3, 7, 15};

    @ParameterizedTest(name = "Test case with input: {arguments}")
    @ValueSource(ints = {0, 1, 5, 10, 20, 100, -1, 3, 7, 15})
    void stringSequence_vs_generateNumberSeries(int n) {
        assertEquals(
            SourceCode.stringSequence(n),
            TransformedCode.generateNumberSeries(n)
        );
    }
}