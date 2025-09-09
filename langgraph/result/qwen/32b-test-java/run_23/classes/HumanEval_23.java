import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_23 {

    // Source Code
    static class SourceCode {
        public int strlen(String string) {
            return string.length();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateStringLength(String text) {
            int count = 0;
            for (char character : text.toCharArray()) {
                count += 1;
            }
            return count;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "",          // Empty string
        "a",         // Single character
        "hello",     // Simple word
        "OpenAI",    // Mixed case
        "1234567890",// Numeric characters
        "!@#$%^&*()",// Special characters
        "spaces in between",  // Multiple words with spaces
        "repeated repeated repeated", // Repeated words
        "A quick brown fox jumps over the lazy dog", // Sentence
        "Python unittest framework" // Another sentence with spaces and lowercase/uppercase mix
    };

    private static Stream<String> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing strlen vs calculateStringLength equivalence")
    void test_strlen_vs_calculateStringLength(String inputText) {
        assertEquals(
            new SourceCode().strlen(inputText),
            new TransformedCode().calculateStringLength(inputText)
        );
    }
}