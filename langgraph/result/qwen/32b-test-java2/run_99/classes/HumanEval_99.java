import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_99 {

    // Source Code
    static class SourceCode {
        public static int closestInteger(String value) {
            if (value.contains(".")) {
                // Remove trailing zeros
                while (value.endsWith("0")) {
                    value = value.substring(0, value.length() - 1);
                }
            }

            double num = Double.parseDouble(value);
            int res;
            if (value.endsWith(".5")) {
                if (num > 0) {
                    res = (int) Math.ceil(num);
                } else {
                    res = (int) Math.floor(num);
                }
            } else if (!value.isEmpty()) {
                res = (int) Math.round(num);
            } else {
                res = 0;
            }

            return res;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int nearestWholeNumber(String inputValue) {
            if (inputValue.contains(".")) {
                // strip trailing zeros
                while (inputValue.endsWith("0")) {
                    inputValue = inputValue.substring(0, inputValue.length() - 1);
                }
            }

            double number = Double.parseDouble(inputValue);
            int result;
            if (inputValue.endsWith(".5")) {
                result = number > 0 ? (int) Math.ceil(number) : (int) Math.floor(number);
            } else if (!inputValue.isEmpty()) {
                result = (int) Math.round(number);
            } else {
                result = 0;
            }

            return result;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "4.5",
        "-2.5",
        "3.7",
        "-1.2",
        "0.0",
        "5.000",
        "6.99",
        "-3.01",
        ".5",
        "-.5"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing closestInteger vs nearestWholeNumber equivalence")
    void closestInteger_vs_nearestWholeNumber(String inputText) {
        assertEquals(
            SourceCode.closestInteger(inputText),
            TransformedCode.nearestWholeNumber(inputText)
        );
    }
}