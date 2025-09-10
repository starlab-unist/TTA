import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_66 {

    // Source Code
    static class SourceCode {
        public static int digitSum(String s) {
            if (s.isEmpty()) return 0;
            int sum = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    sum += (int) c;
                }
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculate_uppercase_ascii_sum(String inputString) {
            if (inputString.equals("")) {
                return 0;
            }
            
            int total = 0;
            for (char character : inputString.toCharArray()) {
                if (Character.isUpperCase(character)) {
                    total += (int) character;
                }
            }
            
            return total;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "abc",
        "ABC",
        "Hello World!",
        "Python3.8",
        "OpenAI",
        "1234567890",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "MIXeD CaSe 123",
        "UPPER lower"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing digitSum vs calculate_uppercase_ascii_sum")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testDigitSum_vs_calculateUppercaseAsciiSum(String inputText) {
        assertEquals(
            SourceCode.digitSum(inputText),
            new TransformedCode().calculate_uppercase_ascii_sum(inputText)
        );
    }
}