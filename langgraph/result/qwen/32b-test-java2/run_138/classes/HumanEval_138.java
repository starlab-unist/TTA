import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
static class OriginalImpl {
    public static boolean isEqualToSumEven(int n) {
        return n % 2 == 0 && n >= 8;
    }
}

// Transformed Code
static class TransformedImpl {
    public static boolean checkEvenAndMinimumEight(int number) {
        return number % 2 == 0 && number >= 8;
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_138 {

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(4, false),
            Arguments.of(6, false),
            Arguments.of(8, true),
            Arguments.of(10, true),
            Arguments.of(12, true),
            Arguments.of(7, false),
            Arguments.of(9, false),
            Arguments.of(0, false),
            Arguments.of(-2, false),
            Arguments.of(14, true),  // Additional test case
            Arguments.of(16, true)   // Additional test case
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEquality(int input, boolean expected) {
        assertEquals(OriginalImpl.isEqualToSumEven(input), 
                     TransformedImpl.checkEvenAndMinimumEight(input));
    }
}