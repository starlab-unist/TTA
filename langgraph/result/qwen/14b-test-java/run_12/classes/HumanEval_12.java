import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_12 {

    // Source Code
    static class HumanEval_12_Original {
        public static String longest(List<String> strings) {
            if (strings.isEmpty()) {
                return null;
            }

            int maxlen = 0;
            for (String s : strings) {
                maxlen = Math.max(maxlen, s.length());
            }

            for (String s : strings) {
                if (s.length() == maxlen) {
                    return s;
                }
            }

            return null; // This line is technically redundant due to the loop's logic
        }
    }

    // Transformed Code
    static class HumanEval_12_Transformed {
        public static String findLongestString(List<String> stringList) {
            if (stringList == null || stringList.isEmpty()) {
                return null;
            }

            int maxLength = 0;
            for (String element : stringList) {
                if (element.length() > maxLength) {
                    maxLength = element.length();
                }
            }

            for (String element : stringList) {
                if (element.length() == maxLength) {
                    return element;
                }
            }

            return null;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(List.of("apple", "banana", "cherry"), "banana")},
        {Arguments.of(List.of("dog", "cat"), "dog")},
        {Arguments.of(List.of(), null)},
        {Arguments.of(List.of("a", "ab", "abc", "abcd", "abcde", "abcd"), "abcde")},
        {Arguments.of(List.of("same", "size", "word"), "same")},
        {Arguments.of(List.of("one", "two", "three", "four"), "three")},
        {Arguments.of(List.of("short", "longer", "longest", "longerer", "longererest"), "longererest")},
        {Arguments.of(List.of("1234567890", "123", "123456789"), "1234567890")},
        {Arguments.of(List.of("same", "same", "same"), "same")},
        {Arguments.of(List.of("unique"), "unique")}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void longest_vs_findLongestString(Arguments inputAndExpected) {
        List<String> input = (List<String>) inputAndExpected.get()[0];
        String expected = (String) inputAndExpected.get()[1];
        
        assertEquals(
            HumanEval_12_Original.longest(input),
            HumanEval_12_Transformed.findLongestString(input)
        );
    }
}