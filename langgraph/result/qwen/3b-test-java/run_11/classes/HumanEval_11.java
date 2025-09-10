import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_11 {

    // Source Code (Revised for compatibility)
    static class OriginalImpl {
        public static String stringXor(String a, String b) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                char c1 = a.charAt(i);
                char c2 = b.charAt(i);
                result.append(xor(c1, c2));
            }
            return result.toString();
        }

        private static char xor(char i, char j) {
            if (i == j) {
                return '0';
            } else {
                return '1';
            }
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String binaryStringDifference(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            int index = 0;

            while (index < str1.length()) {
                char c1 = str1.charAt(index);
                char c2 = str2.charAt(index);
                result.append(bitDiff(c1, c2));
                index++;
            }

            return result.toString();
        }

        private static char bitDiff(char c1, char c2) {
            return c1 == c2 ? '0' : '1';
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("1101", "1001"),
            Arguments.of("1111", "0000"),
            Arguments.of("0000", "0000"),
            Arguments.of("101010", "010101"),
            Arguments.of("111000", "111000"),
            Arguments.of("110011", "001100"),
            Arguments.of("1", "1"),
            Arguments.of("0", "0"),
            Arguments.of("10", "01"),
            Arguments.of("11111111", "00000000")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testStringXorAndBinaryStringDifference(String a, String b) {
        assertEquals(OriginalImpl.stringXor(a, b), TransformedImpl.binaryStringDifference(a, b));
    }
}