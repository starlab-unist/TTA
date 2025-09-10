import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_7 {

    // Source Code
    static class SourceCode {
        public static List<String> filterBySubstring(List<String> strings, String substring) {
            List<String> result = new ArrayList<>();
            for (String x : strings) {
                if (x.contains(substring)) {
                    result.add(x);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<String> extractMatchingStrings(List<String> sequence, String pattern) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while (index < sequence.size()) {
                if (sequence.get(index).contains(pattern)) {
                    result.add(sequence.get(index));
                }
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = List.of(
        Arguments.of(List.of("hello", "world", "help"), "he"),
        Arguments.of(List.of("apple", "banana", "cherry"), "a"),
        Arguments.of(List.of("one", "two", "three"), "four"),
        Arguments.of(new ArrayList<>(), "test"),
        Arguments.of(List.of("abc", "def", "ghi"), ""),
        Arguments.of(List.of("123", "456", "789"), "5"),
        Arguments.of(List.of("repeat", "repeal", "replace"), "rep"),
        Arguments.of(List.of("same", "same", "same"), "s"),
        Arguments.of(List.of("unique"), "uni"),
        Arguments.of(List.of("different", "words", "here"), "word")
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing filterBySubstring vs extractMatchingStrings equivalence")
    void filterBySubstring_vs_extractMatchingStrings(List<String> inputList, String inputSubstring) {
        assertEquals(
            SourceCode.filterBySubstring(inputList, inputSubstring),
            new TransformedCode().extractMatchingStrings(inputList, inputSubstring)
        );
    }
}