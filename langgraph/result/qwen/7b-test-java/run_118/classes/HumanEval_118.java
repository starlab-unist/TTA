import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    static class OriginalImpl {
        public static String getClosestVowel(String word) {
            if (word.length() < 3) {
                return "";
            }

            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');

            for (int i = word.length() - 2; i > 0; i--) {
                if (vowels.contains(word.charAt(i))) {
                    if (!vowels.contains(word.charAt(i + 1)) && !vowels.contains(word.charAt(i - 1))) {
                        return String.valueOf(word.charAt(i));
                    }
                }
            }
            return "";
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String getClosestVowel(String word) {
            if (word.length() < 3) {
                return "";
            }

            Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            int index = word.length() - 2;

            while (index > 0) {
                if (vowels.contains(word.charAt(index))) {
                    if (!vowels.contains(word.charAt(index + 1)) && !vowels.contains(word.charAt(index - 1))) {
                        return String.valueOf(word.charAt(index));
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
    public void testGetClosestVowel(String word) {
        assertEquals(OriginalImpl.getClosestVowel(word), TransformedImpl.getClosestVowel(word));
    }
}