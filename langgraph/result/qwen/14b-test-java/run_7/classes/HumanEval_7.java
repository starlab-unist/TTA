import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_7 {

    // Source Code
    static class SourceCode {
        public static List<String> filterBySubstring(List<String> strings, String substring) {
            List<String> result = new ArrayList<>();
            for (String str : strings) {
                if (str.contains(substring)) {
                    result.add(str);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<String> extractMatchingStrings(List<String> sequence, String pattern) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while (index < sequence.size()) {
                if (sequence.get(index).contains(pattern)) {
                    result.add(sequence.get(index));
                }
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList("hello", "world", "help"), "he"),
        Arguments.of(Arrays.asList("apple", "banana", "cherry"), "a"),
        Arguments.of(Arrays.asList("one", "two", "three"), "four"),
        Arguments.of(new ArrayList<>(), "test"),
        Arguments.of(Arrays.asList("abc", "def", "ghi"), ""),
        Arguments.of(Arrays.asList("123", "456", "789"), "5"),
        Arguments.of(Arrays.asList("repeat", "repeal", "replace"), "rep"),
        Arguments.of(Arrays.asList("same", "same", "same"), "s"),
        Arguments.of(Arrays.asList("unique"), "uni"),
        Arguments.of(Arrays.asList("different", "words", "here"), "word")
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @DisplayName("Compare source and transformed functions")
    @ParameterizedTest(name = "{index} => input={0}, substring={1}")
    @MethodSource("provideTestCases")
    void filterBySubstring_vs_extractMatchingStrings(List<String> inputList, String inputSubstring) {
        assertEquals(
            SourceCode.filterBySubstring(inputList, inputSubstring),
            TransformedCode.extractMatchingStrings(inputList, inputSubstring)
        );
    }
}