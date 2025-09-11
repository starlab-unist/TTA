import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_158 {

    // Source Code
    static class OriginalImpl {
        public static String findMax(String[] words) {
            Arrays.sort(words, (s1, s2) -> {
                int lenCompare = Integer.compare(s2.length(), s1.length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                return s1.compareTo(s2);
            });
            return words[0];
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String findMax(List<String> words) {
            List<String> sortedWords = new ArrayList<>(words);
            sortedWords.sort((w1, w2) -> {
                int lenCompare = Integer.compare(w2.length(), w1.length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                return w1.compareTo(w2);
            });
            return sortedWords.get(0);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new String[]{"apple", "banana", "cherry"}),
            Arguments.of(new String[]{"abc", "abcd", "abcde"}),
            Arguments.of(new String[]{"aaaa", "bb", "c"}),
            Arguments.of(new String[]{"hello", "world", "python"}),
            Arguments.of(new String[]{"same", "size", "test"}),
            Arguments.of(new String[]{"unique", "chars", "words"}),
            Arguments.of(new String[]{"one", "two", "three"}),
            Arguments.of(new String[]{"four", "five", "six"}),
            Arguments.of(new String[]{"seven", "eight", "nine"}),
            Arguments.of(new String[]{"ten", "eleven", "twelve"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testFindMax(String[] words) {
        List<String> wordsList = Arrays.asList(words);
        assertEquals(OriginalImpl.findMax(words), TransformedImpl.findMax(wordsList));
    }
}