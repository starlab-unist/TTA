import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_158 {

    // Source Code
    static class SourceCode {
        public static String findMax(List<String> words) {
            return Collections.max(words, Comparator.comparing((String x) -> -new java.util.HashSet<Character>(toCharacterList(x)).size()).thenComparing(Comparator.naturalOrder()));
        }

        private static List<Character> toCharacterList(String s) {
            List<Character> characterList = new ArrayList<>();
            for (char c : s.toCharArray()) {
                characterList.add(c);
            }
            return characterList;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String determineLongestUniqueCharString(List<String> wordList) {
            Comparator<String> customSortKey = (word1, word2) -> {
                int uniqueCharsCount1 = new HashSet<>(Arrays.asList(word1.split(""))).size();
                int uniqueCharsCount2 = new HashSet<>(Arrays.asList(word2.split(""))).size();
                if (uniqueCharsCount1 != uniqueCharsCount2) {
                    return Integer.compare(uniqueCharsCount2, uniqueCharsCount1);
                } else {
                    return word1.compareTo(word2);
                }
            };

            List<String> sortedWords = new ArrayList<>(wordList);
            Collections.sort(sortedWords, customSortKey);
            return sortedWords.get(0);
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"apple", "banana", "cherry"},
        {"abc", "abcd", "abcde"},
        {"aaaa", "bb", "c"},
        {"hello", "world", "python"},
        {"same", "size", "test"},
        {"unique", "chars", "words"},
        {"one", "two", "three"},
        {"four", "five", "six"},
        {"seven", "eight", "nine"},
        {"ten", "eleven", "twelve"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findMax_vs_determineLongestUniqueCharString(String[] inputWords) {
        List<String> wordsList = Arrays.asList(inputWords);
        assertEquals(
            SourceCode.findMax(wordsList),
            TransformedCode.determineLongestUniqueCharString(wordsList)
        );
    }
}