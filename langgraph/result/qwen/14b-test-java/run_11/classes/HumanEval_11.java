import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;         // Added import for Arrays

public class HumanEval_11 {

    // Source Code
    static class SourceCode {
        public static String stringXor(String a, String b) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                char x = a.charAt(i);
                char y = b.charAt(i);
                if (x == y) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String binaryStringDifference(String str1, String str2) {
            return bitDiff(str1, str2);
        }

        private static String bitDiff(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < str1.length()) {
                result.append(str1.charAt(index) == str2.charAt(index) ? '0' : '1');
                index++;
            }
            return result.toString();
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

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing stringXor vs binaryStringDifference equivalence")
    void stringXor_vs_binaryStringDifference(String a, String b) {
        assertEquals(
            SourceCode.stringXor(a, b),
            TransformedCode.binaryStringDifference(a, b)
        );
    }
}