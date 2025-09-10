import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_15 {

    // Source Code
    static class SourceCode {
        public static String stringSequence(int n) {
            StringBuilder result = new StringBuilder();
            for (int x = 0; x <= n; x++) {
                result.append(x).append(" ");
            }
            return result.toString().trim();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String generateNumberSeries(int length) {
            StringBuilder numberList = new StringBuilder();
            int index = 0;

            while (index <= length) {
                numberList.append(index).append(" ");
                index++;
            }

            // Remove the trailing space
            if (numberList.length() > 0) {
                numberList.setLength(numberList.length() - 1);
            }

            return numberList.toString();
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  // Edge case: negative input
        3,
        7,
        15
    };

    private static Stream<Integer> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void stringSequence_vs_generateNumberSeries(int n) {
        assertEquals(
            SourceCode.stringSequence(n),
            TransformedCode.generateNumberSeries(n)
        );
    }
}