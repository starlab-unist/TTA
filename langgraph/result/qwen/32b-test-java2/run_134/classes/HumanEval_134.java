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

public class HumanEval_134 {

    // Source Code
    static class OriginalImpl {
        public static boolean checkIfLastCharIsALetter(String txt) {
            String[] parts = txt.split(" ");
            if (parts.length == 0) return false; // Handle empty string case
            String check = parts[parts.length - 1];
            return check.length() == 1 && (check.toLowerCase().charAt(0) >= 'a' && check.toLowerCase().charAt(0) <= 'z');
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
            String[] words = inputString.split(" ");
            if (words.length == 0) return false; // Handle empty string case
            String lastWord = words[words.length - 1];
            return lastWord.length() == 1 && lastWord.toLowerCase().matches("[a-z]");
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("hello world a"),
                Arguments.of("test z"),
                Arguments.of("123 b"),
                Arguments.of("c"),
                Arguments.of("no letters here !"),
                Arguments.of("singleword x"),
                Arguments.of("spaces at the end "),
                Arguments.of("  leading spaces y"),
                Arguments.of(""),
                Arguments.of("onlyoneletter")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(String input) {
        boolean originalResult = OriginalImpl.checkIfLastCharIsALetter(input);
        boolean transformedResult = TransformedImpl.determineIfFinalCharacterIsAlphabetic(input);
        assertEquals(originalResult, transformedResult, "Input: " + input);
    }
}