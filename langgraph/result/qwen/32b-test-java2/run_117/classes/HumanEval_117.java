import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_117 {

    // Source Code
    static class HumanEval_117_Source {
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
    static class HumanEval_117_Transformed {
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
    private static final Object[][] testCases = {
        {"hello world", 3},
        {"this is a test", 2},
        {"consonants and vowels", 4},
        {"python programming", 5},
        {"simple words", 1},
        {"", 0},
        {"a e i o u", 0},
        {"bcd fgh jkl", 3},
        {"same same same", 3},
        {"different words here", 4}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void selectWords_vs_filterWordsByConsonantCount(String inputText, int n) {
        HumanEval_117_Source source = new HumanEval_117_Source();
        HumanEval_117_Transformed transformed = new HumanEval_117_Transformed();

        assertEquals(
            source.selectWords(inputText, n),
            transformed.filterWordsByConsonantCount(inputText, n)
        );
    }
}