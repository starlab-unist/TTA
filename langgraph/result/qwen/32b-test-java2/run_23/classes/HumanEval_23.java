import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

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
    void strlen_vs_calculateStringLength(String inputText) {
        assertEquals(
            new SourceCode().strlen(inputText),
            new TransformedCode().calculateStringLength(inputText)
        );
    }
}