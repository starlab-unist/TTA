import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_125 {

    // Source Code
    static class OriginalImpl {
        public static List<String> splitWords(String txt) {
            if (txt.contains(" ")) {
                return Arrays.asList(txt.split(" "));
            } else if (txt.contains(",")) {
                return Arrays.asList(txt.replace(',', ' ').split(" "));
            } else {
                long count = txt.chars()
                                 .filter(c -> Character.isLowerCase(c) && c % 2 == 0)
                                 .count();
                return Arrays.asList(Long.toString(count));
            }
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static Object extract_and_count_words(String input_text) {
            if (input_text.contains(" ")) {
                List<String> word_list = Arrays.asList(input_text.split(" "));
                return word_list;
            } else if (input_text.contains(",")) {
                List<String> word_list = Arrays.asList(input_text.replace(",", " ").split(" "));
                return word_list;
            } else {
                int count = 0;
                for (char c : input_text.toCharArray()) {
                    if (Character.isLowerCase(c) && (int) c % 2 == 0) {
                        count++;
                    }
                }
                return count;
            }
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("hello world"),
            Arguments.of("apple,banana,cherry"),
            Arguments.of("one,two three"),
            Arguments.of("abcdefg"),
            Arguments.of("hijklmno"),
            Arguments.of("pqrstuvw"),
            Arguments.of("xyz"),
            Arguments.of("123456"),
            Arguments.of(""),
            Arguments.of("a,b,c,d,e,f,g,h,i,j")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(String input) {
        Object originalResult = OriginalImpl.splitWords(input);
        Object transformedResult = TransformedImpl.extract_and_count_words(input);

        if (originalResult instanceof List && transformedResult instanceof List) {
            assertEquals(originalResult, transformedResult);
        } else {
            // Handle the case where the results are integers
            assertEquals(Integer.parseInt(String.valueOf(originalResult)), 
                         Integer.parseInt(String.valueOf(transformedResult)));
        }
    }
}