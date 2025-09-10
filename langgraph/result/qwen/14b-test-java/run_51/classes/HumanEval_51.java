import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Stream;

public class HumanEval_51 {

    // Source Code
    static class HumanEval_51_Source {
        public static String removeVowels(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (!"aeiouAEIOU".contains(String.valueOf(c))) {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class HumanEval_51_Transformed {
        public static String strip_vowels(String input_string) {
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            StringBuilder result = new StringBuilder();
            int index = 0;

            while (index < input_string.length()) {
                char charAt = input_string.charAt(index);
                if (!vowels.contains(charAt)) {
                    result.append(charAt);
                }
                index++;
            }

            return result.toString();
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"Hello, World!"},
        {"Python Programming"},
        {"AEIOUaeiou"},
        {"abcdefghijklmnopqrstuvwxyz"},
        {"THE quick brown fox JUMPS over the LAZY dog"},
        {"1234567890"},
        {"!@#$%^&*()_+"},
        {"OpenAI"},
        {"a b c d e f g h i j"},
        {"This is a simple test case."}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void removeVowels_vs_strip_vowels(String inputText) {
        assertEquals(
            HumanEval_51_Source.removeVowels(inputText),
            HumanEval_51_Transformed.strip_vowels(inputText)
        );
    }
}