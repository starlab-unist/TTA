import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                    if (Character.isLowerCase(c) && ((int) c % 2 == 0)) {
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
                    if (Character.isLowerCase(c) && ((int) c % 2 == 0)) {
                        count++;
                    }
                }
                return List.of(String.valueOf(count));
            }
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("hello world", Arrays.asList("hello", "world")),       // contains space, should split by spaces
            Arguments.of("apple,banana,cherry", Arrays.asList("apple", "banana", "cherry")), // contains comma, should replace comma with space and split
            Arguments.of("one,two three", Arrays.asList("one", "two", "three")),     // mixed usage of comma and space, should handle both correctly
            Arguments.of("abcdefg", Arrays.asList("3")),           // no spaces or commas, count lowercase chars with even ASCII values (b, d, f)
            Arguments.of("hijklmno", Arrays.asList("2")),          // no spaces or commas, count lowercase chars with even ASCII values (j, l)
            Arguments.of("pqrstuvw", Arrays.asList("2")),          // no spaces or commas, count lowercase chars with even ASCII values (r, v)
            Arguments.of("xyz", Arrays.asList("0")),               // no spaces or commas, count lowercase chars with even ASCII values ()
            Arguments.of("123456", Arrays.asList("0")),            // only numbers, should return 0
            Arguments.of("", Arrays.asList()),                  // empty string, should return empty list
            Arguments.of("a,b,c,d,e,f,g,h,i,j", Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")) // contains comma, should replace comma with space and split
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing splitWords vs extract_and_count_words")
    void testSplitWordsVsExtractAndCountWords(String inputText, List<String> expectedOutput) {
        assertEquals(
            SourceCode.splitWords(inputText),
            new TransformedCode().extract_and_count_words(inputText)
        );
    }
}