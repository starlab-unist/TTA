import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class HumanEval_16 {

    // Source Code
    static class HumanEval_16_Source {
        public static int countDistinctCharacters(String string) {
            Set<Character> distinctChars = new HashSet<>();
            for (char c : string.toLowerCase().toCharArray()) {
                distinctChars.add(c);
            }
            return distinctChars.size();
        }
    }

    // Transformed Code
    static class HumanEval_16_Transformed {
        public int determineUniqueCharCount(String inputText) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : inputText.toLowerCase().toCharArray()) {
                uniqueChars.add(c);
            }
            return uniqueChars.size();
        }
    }

    // Test Cases
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

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of countDistinctCharacters and determineUniqueCharCount")
    void countDistinctCharacters_vs_determineUniqueCharCount(String inputText) {
        assertEquals(
            HumanEval_16_Source.countDistinctCharacters(inputText),
            new HumanEval_16_Transformed().determineUniqueCharCount(inputText)
        );
    }
}