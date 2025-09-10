{source_code}
// Source Code
static class SourceCode {
    public static String intToMiniRoman(int number) {
        int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 12;
        StringBuilder res = new StringBuilder();
        while (number > 0) {
            int div = number / num[i];
            number %= num[i];
            while (div > 0) {
                res.append(sym[i]);
                div--;
            }
            i--;
        }
        return res.toString().toLowerCase();
    }
}

{transformed_code}
// Transformed Code
static class TransformedCode {
    public static String convertIntegerToMinimalRoman(int value) { // Changed to static
        int[] numeralValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = numeralValues.length - 1;
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            int quotient = value / numeralValues[index];
            value %= numeralValues[index];
            while (quotient > 0) {
                result.append(romanSymbols[index]);
                quotient--;
            }
            index--;
        }
        return result.toString().toLowerCase();
    }
}

{test_cases}
// Test Cases
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_156 {

    private static final Arguments[] testCases = {
        Arguments.of(1, "i"),
        Arguments.of(4, "iv"),
        Arguments.of(9, "ix"),
        Arguments.of(58, "lviii"),
        Arguments.of(1994, "mcmxciv"),
        Arguments.of(3999, "mmmcmxcix"),
        Arguments.of(1000, "m"),
        Arguments.of(500, "d"),
        Arguments.of(100, "c"),
        Arguments.of(10, "x")
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void intToMiniRoman_vs_convertIntegerToMinimalRoman(int inputNumber, String expectedOutput) {
        assertEquals(
            SourceCode.intToMiniRoman(inputNumber),
            TransformedCode.convertIntegerToMinimalRoman(inputNumber)
        );
    }
}