import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Import Arrays class
import java.util.stream.Stream;  // Import Stream class

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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void stringSequence_vs_generateNumberSeries(int input) {
        SourceCode sourceInstance = new SourceCode();  // Create an instance of SourceCode
        TransformedCode transformedInstance = new TransformedCode();  // Create an instance of TransformedCode

        assertEquals(
            sourceInstance.stringSequence(input),
            transformedInstance.generateNumberSeries(input)
        );
    }
}