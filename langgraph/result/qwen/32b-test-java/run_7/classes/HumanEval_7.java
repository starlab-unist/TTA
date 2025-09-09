import java.util.Arrays;
import java.util.List;

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
    private static final Object[][] testCases = {
        {Arrays.asList("hello", "world", "help"), "he"},
        {Arrays.asList("apple", "banana", "cherry"), "a"},
        {Arrays.asList("one", "two", "three"), "four"},
        {Arrays.asList(), "test"},
        {Arrays.asList("abc", "def", "ghi"), ""},
        {Arrays.asList("123", "456", "789"), "5"},
        {Arrays.asList("repeat", "repeal", "replace"), "rep"},
        {Arrays.asList("same", "same", "same"), "s"},
        {Arrays.asList("unique"), "uni"},
        {Arrays.asList("different", "words", "here"), "word"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test filterBySubstring vs extractMatchingStrings")
    void testFilterBySubstring_vs_extractMatchingStrings(List<String> inputList, String inputString) {
        TransformedCode transformed = new TransformedCode();
        
        assertEquals(
            SourceCode.filterBySubstring(inputList, inputString),
            transformed.extractMatchingStrings(inputList, inputString)
        );
    }
}