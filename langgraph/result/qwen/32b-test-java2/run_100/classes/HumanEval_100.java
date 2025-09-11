import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HumanEval_100 {

    // Source Code
    static class OriginalImpl {
        public static List<Integer> makeAPile(int n) {
            List<Integer> pile = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pile.add(n + 2 * i);
            }
            return pile;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static List<Integer> constructStack(int size) {
            List<Integer> pile = new ArrayList<>();
            int index = 0;
            while (index < size) {
                pile.add(size + 2 * index);
                index++;
            }
            return pile;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(1),
            Arguments.of(2),
            Arguments.of(3),
            Arguments.of(4),
            Arguments.of(5),
            Arguments.of(10),
            Arguments.of(15),
            Arguments.of(20),
            Arguments.of(25)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMakeAPileEqualsConstructStack(int n) {
        assertEquals(
            OriginalImpl.makeAPile(n), 
            TransformedImpl.constructStack(n)
        );
    }
}