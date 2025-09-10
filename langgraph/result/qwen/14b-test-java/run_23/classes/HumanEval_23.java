import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_23 {

    // Source Code
    static class SourceCode {
        public static int strlen(String string) {
            return string.length();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int calculateStringLength(String text) {
            int count = 0;
            for (char character : text.toCharArray()) {
                count += 1;
            }
            return count;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "a",
        "hello",
        "OpenAI",
        "1234567890",
        "!@#$%^&*()",
        "spaces in between",
        "repeated repeated repeated",
        "A quick brown fox jumps over the lazy dog",
        "Python unittest framework"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare strlen and calculateStringLength outputs for various inputs")
    void strlen_vs_calculateStringLength(String inputText) {
        assertEquals(
            SourceCode.strlen(inputText),
            TransformedCode.calculateStringLength(inputText)
        );
    }
}