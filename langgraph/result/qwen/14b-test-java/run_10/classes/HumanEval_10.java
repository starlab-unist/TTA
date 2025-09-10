import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_10 {

    // Source Code
    static class SourceCode {
        public static boolean isPalindrome(String string) {
            int left = 0;
            int right = string.length() - 1;
            while (left < right) {
                if (string.charAt(left) != string.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public static String makePalindrome(String string) {
            if (string.isEmpty()) {
                return "";
            }

            int beginningOfSuffix = 0;

            while (!isPalindrome(string.substring(beginningOfSuffix))) {
                beginningOfSuffix++;
            }

            StringBuilder suffix = new StringBuilder(string.substring(0, beginningOfSuffix));
            return string + suffix.reverse().toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean checkPalindrome(String sequence) {
            int left = 0;
            int right = sequence.length() - 1;
            while (left < right) {
                if (sequence.charAt(left) != sequence.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public static String constructPalindrome(String inputStr) {
            if (inputStr.isEmpty()) {
                return "";
            }

            int suffixStartIndex = 0;

            while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
                suffixStartIndex++;
            }

            StringBuilder prefix = new StringBuilder(inputStr.substring(0, suffixStartIndex));
            return inputStr + prefix.reverse().toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "racecar",
        "hello",
        "",
        "a",
        "abba",
        "abcba",
        "abc",
        "noon",
        "level",
        "deified"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isPalindrome_vs_checkPalindrome(String inputText) {
        assertEquals(
            SourceCode.isPalindrome(inputText),
            TransformedCode.checkPalindrome(inputText)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void makePalindrome_vs_constructPalindrome(String inputText) {
        assertEquals(
            SourceCode.makePalindrome(inputText),
            TransformedCode.constructPalindrome(inputText)
        );
    }
}