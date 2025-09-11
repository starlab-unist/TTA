import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_101 {

    // Original Implementation
    static class OriginalImpl {
        public static List<String> wordsString(String s) {
            if (s == null || s.isEmpty()) {
                return List.of();
            }

            StringBuilder sBuilder = new StringBuilder();

            for (char letter : s.toCharArray()) {
                if (letter == ',') {
                    sBuilder.append(' ');
                } else {
                    sBuilder.append(letter);
                }
            }

            String result = sBuilder.toString();
            return List.of(result.split("\\s+"));
        }
    }

    // Transformed Implementation
    static class TransformedImpl {
        public static List<String> processText(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return List.of();
            }

            StringBuilder processedStringBuilder = new StringBuilder();

            for (char charAt : inputString.toCharArray()) {
                if (charAt == ',') {
                    processedStringBuilder.append(' ');
                } else {
                    processedStringBuilder.append(charAt);
                }
            }

            String processedString = processedStringBuilder.toString();
            return List.of(processedString.split("\\s+"));
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("Hello,world"),
            Arguments.of("Python,is,great!"),
            Arguments.of("OpenAI,ChatGPT"),
            Arguments.of("This,is,a,test,string"),
            Arguments.of("No commas here"),
            Arguments.of(",Leading and trailing,"),
            Arguments.of("Multiple,,,commas,,here"),
            Arguments.of(""),
            Arguments.of(" "),
            Arguments.of("OneWord")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testWordsString(String input) {
        List<String> originalResult = OriginalImpl.wordsString(input);
        List<String> transformedResult = TransformedImpl.processText(input);
        
        assertEquals(originalResult, transformedResult, "Failed for input: " + input);
    }
}