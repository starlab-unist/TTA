import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_117 {

    // Source Code
    static class SourceCode {
        public List<String> selectWords(String s, int n) {
            List<String> result = new ArrayList<>();
            String[] words = s.split("\\s+");
            for (String word : words) {
                int nConsonants = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = Character.toLowerCase(word.charAt(i));
                    if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                        nConsonants++;
                    }
                }
                if (nConsonants == n) {
                    result.add(word);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<String> filterWordsByConsonantCount(String inputString, int targetConsonantCount) {
            List<String> selectedWords = new ArrayList<>();
            String[] words = inputString.split("\\s+");

            for (String word : words) {
                int consonantCounter = 0;
                int index = 0;
                while (index < word.length()) {
                    char currentChar = word.charAt(index);
                    if ("aeiou".indexOf(Character.toLowerCase(currentChar)) == -1) {
                        consonantCounter++;
                    }
                    index++;
                }

                if (consonantCounter == targetConsonantCount) {
                    selectedWords.add(word);
                }
            }

            return selectedWords;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of("hello world", 3)},
        {Arguments.of("this is a test", 2)},
        {Arguments.of("consonants and vowels", 4)},
        {Arguments.of("python programming", 5)},
        {Arguments.of("simple words", 1)},
        {Arguments.of("", 0)},
        {Arguments.of("a e i o u", 0)},
        {Arguments.of("bcd fgh jkl", 3)},
        {Arguments.of("same same same", 3)},
        {Arguments.of("different words here", 4)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if source and transformed code produce the same output for given inputs")
    void selectWords_vs_filterWordsByConsonantCount(String inputText, int targetConsonantCount) {
        assertEquals(
            SourceCode.selectWords(inputText, targetConsonantCount),
            TransformedCode.filterWordsByConsonantCount(inputText, targetConsonantCount)
        );
    }
}