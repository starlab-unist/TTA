import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_12 {

    // Source Code
    static class SourceCode {
        public static String longest(List<String> strings) {
            if (strings == null || strings.isEmpty()) {
                return null;
            }

            int maxlen = 0;
            for (String s : strings) {
                if (s.length() > maxlen) {
                    maxlen = s.length();
                }
            }

            for (String s : strings) {
                if (s.length() == maxlen) {
                    return s;
                }
            }

            return null; // This line is technically unreachable due to the logic above
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static Optional<String> findLongestString(List<String> stringList) {
            if (stringList == null || stringList.isEmpty()) {
                return Optional.empty();
            }

            int maxLength = stringList.stream().mapToInt(String::length).max().orElse(0);
            for (String element : stringList) {
                if (element.length() == maxLength) {
                    return Optional.of(element);
                }
            }
            return Optional.empty();
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("apple", "banana", "cherry"), "banana"},
        {Arrays.asList("dog", "cat"), "dog"},
        {Arrays.asList(), null},
        {Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcd"), "abcde"},
        {Arrays.asList("same", "size", "word"), "same"},
        {Arrays.asList("one", "two", "three", "four"), "three"},
        {Arrays.asList("short", "longer", "longest", "longerer", "longererest"), "longererest"},
        {Arrays.asList("1234567890", "123", "123456789"), "1234567890"},
        {Arrays.asList("same", "same", "same"), "same"},
        {Arrays.asList("unique"), "unique"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing equivalence of longest and findLongestString methods")
    @ParameterizedTest(name = "{index} => input={0}, expectedOutput={1}")
    @MethodSource("provideTestCases")
    void longest_vs_findLongestString(List<String> inputStrings, String expectedOutput) {
        String sourceCodeResult = SourceCode.longest(inputStrings);
        Optional<String> transformedCodeResult = TransformedCode.findLongestString(inputStrings);

        assertEquals(
            expectedOutput,
            (sourceCodeResult == null ? null : sourceCodeResult),
            "Source Code Output"
        );
        assertEquals(
            expectedOutput,
            (transformedCodeResult.isPresent() ? transformedCodeResult.get() : null),
            "Transformed Code Output"
        );
    }
}