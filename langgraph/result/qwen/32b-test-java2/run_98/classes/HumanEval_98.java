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

public class HumanEval_98 {

    // Source Code
    static class OriginalImpl {
        public static int countUpper(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i += 2) {
                if ("AEIOU".indexOf(s.charAt(i)) != -1) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static int tallyEvenIndexVowels(String inputString) {
            int vowelCount = 0;
            int index = 0;
            while (index < inputString.length()) {
                if (index % 2 == 0 && "AEIOU".indexOf(inputString.charAt(index)) != -1) {
                    vowelCount++;
                }
                index++;
            }
            return vowelCount;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments("", 0),
                Arguments.arguments("A", 1),
                Arguments.arguments("B", 0),
                Arguments.arguments("AEIOU", 3),
                Arguments.arguments("aeiou", 0),
                Arguments.arguments("AbEcIdOfUg", 2),
                Arguments.arguments("abcdefgHIJKL", 0),
                Arguments.arguments("HELLOworld", 1),
                Arguments.arguments("Python", 0),
                Arguments.arguments("UPPERlower", 1),
                Arguments.arguments("AEIOU" + "AEIOU" + "AEIOU" + "AEIOU" + "AEIOU", 8), // "AEIOUAEIOUAEIOUAEIOUAEIOU"
                Arguments.arguments("AxBxCxDxExF", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCountUpper(String input, int expected) {
        assertEquals(OriginalImpl.countUpper(input), TransformedImpl.tallyEvenIndexVowels(input));
    }
}