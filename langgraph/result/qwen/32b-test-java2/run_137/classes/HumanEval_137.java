import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_137 {

    // Source Code
    static class SourceCode {
        public static Object compareOne(Object a, Object b) {
            String tempA = a.toString();
            String tempB = b.toString();

            if (tempA.contains(",")) tempA = tempA.replace(',', '.');
            if (tempB.contains(",")) tempB = tempB.replace(',', '.');

            float numA = Float.parseFloat(tempA);
            float numB = Float.parseFloat(tempB);

            if (numA == numB) return null;
            return numA > numB ? a : b;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public Object evaluateAndCompare(Object value1, Object value2) {
            String modifiedVal1 = value1.toString();
            String modifiedVal2 = value2.toString();

            if (modifiedVal1.contains(",")) {
                modifiedVal1 = modifiedVal1.replace(',', '.');
            }
            if (modifiedVal2.contains(",")) {
                modifiedVal2 = modifiedVal2.replace(',', '.');
            }

            double numericVal1 = Double.parseDouble(modifiedVal1);
            double numericVal2 = Double.parseDouble(modifiedVal2);

            if (numericVal1 == numericVal2) {
                return null;
            } else if (numericVal1 > numericVal2) {
                return value1;
            } else {
                return value2;
            }
        }
    }

    private static final TransformedCode transformedInstance = new TransformedCode();

    private static final Object[][] testCases = {
        {5, 3},
        {"4.5", "4.6"},
        {"7,8", "7.8"},
        {"10", 10},
        {"123", "123.0"},
        {"1,234", "1.234"},
        {"9.99", 9.990},
        {"5", "5"},
        {"6", 6},
        {"7.5", "7,5"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("compareOne vs evaluateAndCompare")
    void compareOne_vs_evaluateAndCompare(Object a, Object b) {
        assertEquals(
            SourceCode.compareOne(a, b),
            transformedInstance.evaluateAndCompare(a, b)
        );
    }
}