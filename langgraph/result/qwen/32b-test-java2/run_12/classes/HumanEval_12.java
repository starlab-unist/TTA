// Import statements at the top
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class SourceCode {
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
class TransformedCode {
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
public class HumanEval_12 {

    private static final Arguments[] testCases = {
        Arguments.of(List.of("apple", "banana", "cherry"), "banana"),
        Arguments.of(List.of("dog", "cat"), "dog"),
        Arguments.of(List.of(), null),
        Arguments.of(List.of("a", "ab", "abc", "abcd", "abcde", "abcd"), "abcde"),
        Arguments.of(List.of("same", "size", "word"), "same"),
        Arguments.of(List.of("one", "two", "three", "four"), "three"),
        Arguments.of(List.of("short", "longer", "longest", "longerer", "longererest"), "longererest"),
        Arguments.of(List.of("1234567890", "123", "123456789"), "1234567890"),
        Arguments.of(List.of("same", "same", "same"), "same"),
        Arguments.of(List.of("unique"), "unique"),
        Arguments.of(null, null), // Edge case: null input
        Arguments.of(List.of(""), ""), // Edge case: empty string in list
        Arguments.of(List.of("a"), "a"), // Single element
        Arguments.of(List.of("equal", "equal", "equal"), "equal") // All elements same length
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void longest_vs_findLongestString(List<String> inputStrings, String expected) {
        assertEquals(
            SourceCode.longest(inputStrings),
            TransformedCode.findLongestString(inputStrings).orElse(null)
        );
    }
}