import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays; // Added import for Arrays
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_44 {

    // Source Code
    static class HumanEval_44_Source {
        public static String changeBase(int x, int base) {
            StringBuilder ret = new StringBuilder();
            while (x > 0) {
                ret.insert(0, x % base);
                x /= base;
            }
            return ret.toString();
        }
    }

    // Transformed Code
    static class HumanEval_44_Transformed {
        public String convertToBase(int number, int targetBase) {
            StringBuilder result = new StringBuilder();
            while (number > 0) {
                int remainder = number % targetBase;
                result.insert(0, remainder);
                number = number / targetBase;
            }
            return result.toString();
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(10, 2),   // Binary representation of 10 is 1010
        Arguments.of(255, 16), // Hexadecimal representation of 255 is ff (note: transformed code does not handle this)
        Arguments.of(100, 10), // Decimal representation of 100 is 100
        Arguments.of(7, 3),    // Base 3 representation of 7 is 21
        Arguments.of(0, 5),    // Any base representation of 0 is 0
        Arguments.of(1, 2),    // Binary representation of 1 is 1
        Arguments.of(9, 4),    // Base 4 representation of 9 is 21
        Arguments.of(31, 8),   // Octal representation of 31 is 37
        Arguments.of(64, 2),   // Binary representation of 64 is 1000000
        Arguments.of(81, 9)    // Base 9 representation of 81 is 100
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void changeBase_vs_convertToBase(int number, int base) {
        HumanEval_44_Transformed transformed = new HumanEval_44_Transformed(); // Create an instance of the transformed class
        assertEquals(
            HumanEval_44_Source.changeBase(number, base),
            transformed.convertToBase(number, base)  // Use the instance to call the method
        );
    }
}