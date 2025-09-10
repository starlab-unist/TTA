import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_29 {

    // Source Code
    static class SourceCode {
        public static List<String> filterByPrefix(List<String> strings, String prefix) {
            List<String> result = new ArrayList<>();
            for (String x : strings) {
                if (x.startsWith(prefix)) {
                    result.add(x);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<String> selectStringsWithStartingChars(List<String> wordList, String startSequence) {
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
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList("apple", "banana", "apricot", "avocado"), "a")},
        {Arguments.of(Arrays.asList("hello", "world", "hi", "house"), "h")},
        {Arguments.of(Arrays.asList("test", "testing", "tested"), "te")},
        {Arguments.of(Arrays.asList("one", "two", "three"), "f")},
        {Arguments.of(new ArrayList<>(), "a")},
        {Arguments.of(Arrays.asList("same", "same", "same"), "sa")},
        {Arguments.of(Arrays.asList("prefix", "preface", "presentation"), "pre")},
        {Arguments.of(Arrays.asList("123abc", "abc123", "123456"), "123")},
        {Arguments.of(Arrays.asList("no_match", "nomatch", "notmatch"), "noma")},
        {Arguments.of(Arrays.asList("a", "b", "c", "d"), "z")}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void filterByPrefix_vs_selectStringsWithStartingChars(List<String> inputStrings, String inputPrefix) {
        assertEquals(
            SourceCode.filterByPrefix(inputStrings, inputPrefix),
            TransformedCode.selectStringsWithStartingChars(inputStrings, inputPrefix)
        );
    }
}