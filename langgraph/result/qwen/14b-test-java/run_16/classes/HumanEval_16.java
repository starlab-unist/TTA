// Place imports at the top of the file
import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
public class HumanEval_16 {

    public static class SourceCode {
        public static int countDistinctCharacters(String string) {
            return (int) string.toLowerCase().chars().distinct().count();
        }
    }

    // Transformed Code
    public static class TransformedCode {
        public static int determineUniqueCharCount(String inputText) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : inputText.toLowerCase().toCharArray()) {
                uniqueChars.add(c);
            }
            return uniqueChars.size();
        }
    }

    // Test Cases
    public class HumanEval_16_Test {

        private static final String[] testCases = {
            "Hello",
            "Python",
            "OpenAI",
            "AaBbCc",
            "1234567890",
            "!@#$%^&*()",
            "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz",
            "The quick brown fox jumps over the lazy dog",
            "",
            " "
        };

        private static Stream<Arguments> provideTestCases() {
            return Arrays.stream(testCases).map(Arguments::of);
        }

        @DisplayName("Test countDistinctCharacters vs determineUniqueCharCount")
        @ParameterizedTest(name = "{index} => inputText={0}")
        @MethodSource("provideTestCases")
        void test_countDistinctCharacters_vs_determineUniqueCharCount(String inputText) {
            assertEquals(
                SourceCode.countDistinctCharacters(inputText),
                TransformedCode.determineUniqueCharCount(inputText)
            );
        }
    }

}