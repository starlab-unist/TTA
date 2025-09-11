import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
static class OriginalImpl {
    public static List<Integer> filterIntegers(List<Object> values) {
        List<Integer> result = new ArrayList<>();
        for (Object x : values) {
            if (x instanceof Integer) {
                result.add((Integer) x);
            }
        }
        return result;
    }
}

// Transformed Code
static class TransformedImpl {
    public static List<Integer> extractIntegers(List<Object> data) {
        List<Integer> result = new ArrayList<>();
        for (Object item : data) {
            if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }
}

// Test Cases
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_22 {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testFilterAndExtractIntegers(List<Object> input, List<Integer> expected) {
        assertEquals(OriginalImpl.filterIntegers(input), TransformedImpl.extractIntegers(input));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3.5, "a", 4), List.of(1, 2, 4)),
            Arguments.of(List.of("hello", 100, 200, "world"), List.of(100, 200)),
            Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5)),
            Arguments.of(List.of("x", "y", "z"), List.of()),
            Arguments.of(List.of(null, true, false, 0, 1), List.of(0, 1)),
            Arguments.of(List.of(), List.of()),
            Arguments.of(List.of(1.1, 2.2, 3.3), List.of()),
            Arguments.of(List.of(1, "1", 2, "2", 3, "3"), List.of(1, 2, 3)),
            Arguments.of(List.of(0, -1, -2, 3, 4), List.of(0, -1, -2, 3, 4)),
            Arguments.of(List.of("test", 123, "example", 456), List.of(123, 456))
        );
    }
}