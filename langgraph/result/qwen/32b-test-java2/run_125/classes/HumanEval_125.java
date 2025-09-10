import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;     // Added import for Arrays

public class HumanEval_125 {

    // Source Code
    static class SourceCode {
        public static List<String> splitWords(String txt) {
            if (txt.contains(" ")) {
                return List.of(txt.split("\\s+"));
            } else if (txt.contains(",")) {
                return List.of(txt.replace(',', ' ').split("\\s+"));
            } else {
                int count = 0;
                for (char c : txt.toCharArray()) {
                    if (Character.isLowerCase(c) && c % 2 == 0) {
                        count++;
                    }
                }
                return List.of(String.valueOf(count));
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<String> extract_and_count_words(String input_text) {
            if (input_text.contains(" ")) {
                return List.of(input_text.split("\\s+"));
            } else if (input_text.contains(",")) {
                String cleanedText = input_text.replace(',', ' ');
                return List.of(cleanedText.split("\\s+"));
            } else {
                int count = 0;
                for (char c : input_text.toCharArray()) {
                    if (Character.isLowerCase(c) && ((int) c) % 2 == 0) {
                        count++;
                    }
                }
                return List.of(String.valueOf(count));
            }
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello world"},
        {"apple,banana,cherry"},
        {"one,two three"},
        {"abcdefg"},
        {"hijklmno"},
        {"pqrstuvw"},
        {"xyz"},
        {"123456"},
        {""},
        {"a,b,c,d,e,f,g,h,i,j"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void splitWords_vs_extract_and_count_words(String inputText) {
        assertEquals(
            SourceCode.splitWords(inputText),
            new TransformedCode().extract_and_count_words(inputText)
        );
    }
}