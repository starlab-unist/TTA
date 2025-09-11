import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    static class OriginalImpl {
        public static String getClosestVowel(String word) {
            if (word.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            for (int i = word.length() - 2; i > 0; i--) {
                if (vowels.indexOf(word.charAt(i)) != -1) {
                    if (vowels.indexOf(word.charAt(i + 1)) == -1 && vowels.indexOf(word.charAt(i - 1)) == -1) {
                        return String.valueOf(word.charAt(i));
                    }
                }
            }
            return "";
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String findNearestIsolatedVowel(String sequence) {
            if (sequence.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            int index = sequence.length() - 3;

            while (index > 0) {
                if (vowels.indexOf(sequence.charAt(index)) != -1) {
                    if (vowels.indexOf(sequence.charAt(index + 1)) == -1 && vowels.indexOf(sequence.charAt(index - 1)) == -1) {
                        return String.valueOf(sequence.charAt(index));
                    }
                }
                index--;
            }

            return "";
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("hello"),
            Arguments.of("beautiful"),
            Arguments.of("sequence"),
            Arguments.of("aeiou"),
            Arguments.of("bcdfg"),
            Arguments.of("aebcdfg"),
            Arguments.of("racecar"),
            Arguments.of("xylophone"),
            Arguments.of("umbrella"),
            Arguments.of("algorithm")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testVowelMethods(String input) {
        assertEquals(OriginalImpl.getClosestVowel(input), TransformedImpl.findNearestIsolatedVowel(input));
    }
}