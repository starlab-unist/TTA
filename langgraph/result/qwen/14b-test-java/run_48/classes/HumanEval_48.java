import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_48 {

    // Source Code
    static class SourceCode {
        public static boolean isPalindrome(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean check_palindrome(String sequence) {
            int index = 0;
            int length = sequence.length();
            
            while (index < length / 2) {
                if (sequence.charAt(index) != sequence.charAt(length - index - 1)) {
                    return false;
                }
                index += 1;
            }
            return true;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"racecar"},
        {"level"},
        {"hello"},
        {"world"},
        {""},
        {"a"},
        {"abba"},
        {"abcba"},
        {"noon"},
        {"python"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both isPalindrome and check_palindrome functions produce the same output for given inputs")
    void isPalindrome_vs_check_palindrome(String inputText) {
        assertEquals(
            SourceCode.isPalindrome(inputText),
            TransformedCode.check_palindrome(inputText)
        );
    }
}