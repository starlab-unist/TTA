import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_44 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
        public static String convertToBase(int number, int targetBase) {
            String result = "";
            while (number > 0) {
                int remainder = number % targetBase;
                result = remainder + result;
                number = number / targetBase;
            }
            return result;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "test_changeBase_vs_convertToBase_{index}")
    @CsvSource({
        "10, 2",
        "255, 16",
        "100, 10",
        "7, 3",
        "0, 5",
        "1, 2",
        "9, 4",
        "31, 8",
        "64, 2",
        "81, 9"
    })
    void changeBase_vs_convertToBase(int number, int base) {
        assertEquals(
            SourceCode.changeBase(number, base),
            TransformedCode.convertToBase(number, base)
        );
    }
}