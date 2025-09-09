import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_86 {

    // Source Code
    static class SourceCode {
        public static String antiShuffle(String s) {
            StringBuilder result = new StringBuilder();
            String[] words = s.split(" ");
            
            for (String word : words) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                result.append(new String(chars)).append(" ");
            }
            
            return result.toString().trim();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String orderWordsCharacters(String inputString) {
            StringBuilder result = new StringBuilder();
            String[] words = inputString.split(" ");
            
            for (String word : words) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = new String(chars);
                
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(sortedWord);
            }
            
            return result.toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "hello world",
        "python is fun",
        "openai gpt",
        "shuffle this string",
        "keep it sorted",
        "characters in words",
        "simple test case",
        "another example here",
        "singleword",
        ""
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Check if source and transformed code produce the same output")
    @ParameterizedTest(name = "{index} => input={0}")
    @MethodSource("provideTestCases")
    void antiShuffle_vs_orderWordsCharacters(String inputText) {
        assertEquals(
            SourceCode.antiShuffle(inputText),
            TransformedCode.orderWordsCharacters(inputText)
        );
    }
}