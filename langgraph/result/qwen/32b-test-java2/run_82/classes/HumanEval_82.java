import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
static class OriginalImpl {
    public static boolean primeLength(String string) {
        int l = string.length();
        if (l == 0 || l == 1) {
            return false;
        }
        for (int i = 2; i < l; i++) {
            if (l % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Transformed Code
static class TransformedImpl {
    public static boolean checkPrimeStringLength(String inputText) {
        int stringLength = inputText.length();
        if (stringLength < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor < stringLength) {
            if (stringLength % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}

// Test Cases
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_82 {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("a"),
            Arguments.of("ab"),
            Arguments.of("abc"),
            Arguments.of("abcd"),
            Arguments.of("abcde"),
            Arguments.of("abcdef"),
            Arguments.of("abcdefgh"),
            Arguments.of("abcdefghi"),
            Arguments.of("abcdefghij")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testPrimeLength(String input) {
        assertEquals(OriginalImpl.primeLength(input), TransformedImpl.checkPrimeStringLength(input));
    }
}