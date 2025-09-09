import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_140 {

    // Source Code
    public static class SourceCode {
        public static String fixSpaces(String text) {
            StringBuilder newText = new StringBuilder();
            int i = 0;
            int start = 0, end = 0;
            while (i < text.length()) {
                if (text.charAt(i) == ' ') {
                    end += 1;
                } else {
                    if (end - start > 2) {
                        newText.append("-").append(text.charAt(i));
                    } else if (end - start > 0) {
                        for (int j = 0; j < end - start; j++) {
                            newText.append("_");
                        }
                        newText.append(text.charAt(i));
                    } else {
                        newText.append(text.charAt(i));
                    }
                    start = i + 1;
                    end = i + 1;
                }
                i++;
            }
            if (end - start > 2) {
                newText.append("-");
            } else if (end - start > 0) {
                newText.append("_");
            }
            return newText.toString();
        }
    }

    // Transformed Code
    public static class TransformedCode {
        public String adjustWhitespace(String inputString) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            int begin = 0, finish = 0;
            while (index < inputString.length()) {
                if (inputString.charAt(index) == ' ') {
                    finish++;
                } else {
                    int spaceCount = finish - begin;
                    if (spaceCount > 2) {
                        result.append("-").append(inputString.charAt(index));
                    } else if (spaceCount > 0) {
                        for (int i = 0; i < spaceCount; i++) {
                            result.append("_");
                        }
                        result.append(inputString.charAt(index));
                    } else {
                        result.append(inputString.charAt(index));
                    }
                    begin = index + 1;
                    finish = index + 1;
                }
                index++;
            }
            int finalSpaceCount = finish - begin;
            if (finalSpaceCount > 2) {
                result.append("-");
            } else if (finalSpaceCount > 0) {
                result.append("_");
            }
            return result.toString();
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(new String[]{
            "Hello   world",
            "This is  a test",
            "Multiple     spaces",
            "NoSpacesHere",
            " ",
            "  ",
            "   ",
            "    ",
            "a b c d e f g h i j",
            "OpenAI     Inc",
            "",
            "A B C",
            "Too   many spaces here",
            "SingleSpaceBetweenWords",
            "TrailingSpaces   ",
            " LeadingSpaces",
            "Surrounded   Spaces  "
        }).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare fixSpaces and adjustWhitespace outputs")
    void fixSpaces_vs_adjustWhitespace(String inputText) {
        assertEquals(
            SourceCode.fixSpaces(inputText),
            TransformedCode.adjustWhitespace(inputText)
        );
    }
}