import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_11 {

    // Source Code
    static class SourceCode {
        public static String stringXor(String a, String b) {  // Change to static
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < a.length(); i++) {
                char x = a.charAt(i);
                char y = b.charAt(i);
                result.append(xor(x, y));
            }
            
            return result.toString();
        }

        private static char xor(char i, char j) {  // Change to static
            if (i == j) {
                return '0';
            } else {
                return '1';
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String binaryStringDifference(String str1, String str2) {  // Change to static
            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < str1.length()) {
                result.append(bitDiff(str1.charAt(index), str2.charAt(index)));
                index++;
            }
            return result.toString();
        }

        private static char bitDiff(char c1, char c2) {  // Change to static
            return c1 == c2 ? '0' : '1';
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"1101", "1001"},
        {"1111", "0000"},
        {"0000", "0000"},
        {"101010", "010101"},
        {"111000", "111000"},
        {"110011", "001100"},
        {"1", "1"},
        {"0", "0"},
        {"10", "01"},
        {"11111111", "00000000"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Test stringXor vs binaryStringDifference")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void test_stringXor_vs_binaryStringDifference(String inputA, String inputB) {
        assertEquals(
            SourceCode.stringXor(inputA, inputB),
            TransformedCode.binaryStringDifference(inputA, inputB)
        );
    }
}