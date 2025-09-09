import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_10 {

    // Source Code Methods
    static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    static String makePalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        int beginningOfSuffix = 0;

        while (!isPalindrome(string.substring(beginningOfSuffix))) {
            beginningOfSuffix++;
        }

        return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
    }

    // Transformed Code Methods
    static boolean checkPalindrome(String sequence) {
        return sequence.equals(new StringBuilder(sequence).reverse().toString());
    }

    static String constructPalindrome(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return "";
        }

        int suffixStartIndex = 0;

        while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
            suffixStartIndex++;
        }

        return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
    }

    // Test Cases
    @ParameterizedTest(name = "{index} => input={0}")
    @ValueSource(strings = {"racecar", "hello", "", "a", "abba", "abcba", "abc", "noon", "level", "deified"})
    public void testPalindromeMethods(String testCase) {
        assertEquals(isPalindrome(testCase), checkPalindrome(testCase));
        assertEquals(makePalindrome(testCase), constructPalindrome(testCase));
    }
}