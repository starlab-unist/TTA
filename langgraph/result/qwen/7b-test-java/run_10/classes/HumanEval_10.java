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

public class HumanEval_10 {

    // Source Code
    static class OriginalImpl {
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

            return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
        }
    }

    // Transformed Code
    static class TransformedImpl {
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

            return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("racecar"),
            Arguments.of("hello"),
            Arguments.of(""),
            Arguments.of("a"),
            Arguments.of("abba"),
            Arguments.of("abcba"),
            Arguments.of("abc"),
            Arguments.of("noon"),
            Arguments.of("level"),
            Arguments.of("deified")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testPalindromeMethods(String input) {
        assertEquals(OriginalImpl.isPalindrome(input), TransformedImpl.checkPalindrome(input));
        assertEquals(OriginalImpl.makePalindrome(input), TransformedImpl.constructPalindrome(input));
    }
}