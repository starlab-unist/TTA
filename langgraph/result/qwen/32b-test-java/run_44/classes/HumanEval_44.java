import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_44 {

    // Source Code
    static class SourceCode {
        public static String changeBase(int x, int base) {
            StringBuilder ret = new StringBuilder();
            while (x > 0) {
                int remainder = x % base;
                if (remainder < 10) {
                    ret.insert(0, remainder);
                } else {
                    ret.insert(0, (char)(remainder - 10 + 'A'));
                }
                x /= base;
            }
            // Handle the edge case when x is 0
            return ret.length() > 0 ? ret.toString() : "0";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String convertToBase(int number, int targetBase) {
            StringBuilder result = new StringBuilder();
            while (number > 0) {
                int remainder = number % targetBase;
                if (remainder < 10) {
                    result.insert(0, remainder);
                } else {
                    result.insert(0, (char)(remainder - 10 + 'A'));
                }
                number /= targetBase;
            }
            // Handle the edge case when number is 0
            return result.length() > 0 ? result.toString() : "0";
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(10, 2)},   // Binary representation of 10 is 1010
        {Arguments.of(255, 16)}, // Hexadecimal representation of 255 is FF
        {Arguments.of(100, 10)}, // Decimal representation of 100 is 100
        {Arguments.of(7, 3)},    // Base 3 representation of 7 is 21
        {Arguments.of(0, 5)},    // Any base representation of 0 is 0
        {Arguments.of(1, 2)},    // Binary representation of 1 is 1
        {Arguments.of(9, 4)},    // Base 4 representation of 9 is 21
        {Arguments.of(31, 8)},   // Octal representation of 31 is 37
        {Arguments.of(64, 2)},   // Binary representation of 64 is 1000000
        {Arguments.of(81, 9)},    // Base 9 representation of 81 is 100
        {Arguments.of(5, 5)},    // Base 5 representation of 5 is 10
        {Arguments.of(2, 3)},    // Base 3 representation of 2 is 2
        {Arguments.of(4, 2)},    // Binary representation of 4 is 100
        {Arguments.of(15, 16)},  // Hexadecimal representation of 15 is F
        {Arguments.of(127, 8)}   // Octal representation of 127 is 177
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest(name = "{index} => input={0}, base={1}")
    @MethodSource("provideTestCases")
    void changeBase_vs_convertToBase(int number, int base) {
        assertEquals(
            SourceCode.changeBase(number, base),
            TransformedCode.convertToBase(number, base)
        );
    }
}