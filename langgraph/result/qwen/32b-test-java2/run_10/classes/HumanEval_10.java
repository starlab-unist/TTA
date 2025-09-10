import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_10 {

    // Original Code
    static class OriginalCode {
        /**
         * Test if given string is a palindrome
         */
        public static boolean isPalindrome(String string) {
            return string.equals(new StringBuilder(string).reverse().toString());
        }

        public static String makePalindrome(String string) {
            if (string == null || string.isEmpty()) {
                return "";
            }

            int beginningOfSuffix = 0;

            while (!isPalindrome(string.substring(beginningOfSuffix))) {
                beginningOfSuffix++;
            }

            return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        /** Determine if the provided sequence is a palindrome */
        public static boolean checkPalindrome(String sequence) {
            return sequence.equals(new StringBuilder(sequence).reverse().toString());
        }

        public static String constructPalindrome(String inputStr) {
            if (inputStr == null || inputStr.isEmpty()) {
                return "";
            }

            int suffixStartIndex = 0;

            while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
                suffixStartIndex++;
            }

            return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"racecar"},
        {"hello"},
        {""},
        {"a"},
        {"abba"},
        {"abcba"},
        {"abc"},
        {"noon"},
        {"level"},
        {"deified"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isPalindrome_vs_checkPalindrome(String inputText) {
        assertEquals(
            OriginalCode.isPalindrome(inputText),
            TransformedCode.checkPalindrome(inputText)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void makePalindrome_vs_constructPalindrome(String inputText) {
        assertEquals(
            OriginalCode.makePalindrome(inputText),
            TransformedCode.constructPalindrome(inputText)
        );
    }
}