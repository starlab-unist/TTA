import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_29 {

    // Source Code
    static class HumanEval_29_Source {
        public static List<String> filterByPrefix(List<String> strings, String prefix) {
            return strings.stream()
                          .filter(x -> x.startsWith(prefix))
                          .collect(Collectors.toList());
        }
    }

    // Transformed Code
    static class HumanEval_29_Transformed {
        public List<String> selectStringsWithStartingChars(List<String> wordList, String startSequence) {
            List<String> filteredWords = new ArrayList<>();
            for (String word : wordList) {
                if (word.startsWith(startSequence)) {
                    filteredWords.add(word);
                }
            }
            return filteredWords;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("apple", "banana", "apricot", "avocado"), "a"},
        {Arrays.asList("hello", "world", "hi", "house"), "h"},
        {Arrays.asList("test", "testing", "tested"), "te"},
        {Arrays.asList("one", "two", "three"), "f"},
        {new ArrayList<>(), "a"},  // Corrected to use Arrays.asList for an empty list
        {Arrays.asList("same", "same", "same"), "sa"},
        {Arrays.asList("prefix", "preface", "presentation"), "pre"},
        {Arrays.asList("123abc", "abc123", "123456"), "123"},
        {Arrays.asList("no_match", "nomatch", "notmatch"), "noma"},
        {Arrays.asList("a", "b", "c", "d"), "z"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void filterByPrefix_vs_selectStringsWithStartingChars(List<String> strings, String prefix) {
        assertEquals(
            HumanEval_29_Source.filterByPrefix(strings, prefix),
            new HumanEval_29_Transformed().selectStringsWithStartingChars(strings, prefix)
        );
    }
}