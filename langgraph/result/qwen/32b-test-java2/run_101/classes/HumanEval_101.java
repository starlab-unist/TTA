import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_101 {

    // Source Code
    static class SourceCode {
        public List<String> wordsString(String s) {
            if (s == null || s.isEmpty()) {
                return new ArrayList<>();
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

    // Transformed Code
    static class TransformedCode {
        public List<String> processText(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return new ArrayList<>();
            }

            List<Character> processedChars = new ArrayList<>();

            int index = 0;
            while (index < inputString.length()) {
                char charAt = inputString.charAt(index);
                if (charAt == ',') {
                    processedChars.add(' ');
                } else {
                    processedChars.add(charAt);
                }
                index++;
            }

            StringBuilder processedStringBuilder = new StringBuilder();
            for (char c : processedChars) {
                processedStringBuilder.append(c);
            }

            String processedString = processedStringBuilder.toString();
            return List.of(processedString.split("\\s+"));
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello,world",
        "Python,is,great!",
        "OpenAI,ChatGPT",
        "This,is,a,test,string",
        "No commas here",
        ",Leading and trailing,",
        "Multiple,,,commas,,here",
        "",
        " ",
        "OneWord"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of wordsString and processText methods")
    void wordsString_vs_processText(String inputText) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.wordsString(inputText),
            transformed.processText(inputText)
        );
    }
}