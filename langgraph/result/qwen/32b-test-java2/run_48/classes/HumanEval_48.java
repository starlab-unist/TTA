import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_48 {

    // Source Code
    static class HumanEval_48_Source {
        public boolean isPalindrome(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_48_Transformed {
        public boolean checkPalindrome(String sequence) {
            int index = 0;
            int length = sequence.length();
            
            while (index < length / 2) {
                if (sequence.charAt(index) != sequence.charAt(length - index - 1)) {
                    return false;
                }
                index++;
            }
            return true;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "racecar",
        "level",
        "hello",
        "world",
        "",
        "a",
        "abba",
        "abcba",
        "noon",
        "python"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isPalindrome_vs_checkPalindrome(String inputText) {
        HumanEval_48_Source source = new HumanEval_48_Source();
        HumanEval_48_Transformed transformed = new HumanEval_48_Transformed();

        assertEquals(
            source.isPalindrome(inputText),
            transformed.checkPalindrome(inputText)
        );
    }
}