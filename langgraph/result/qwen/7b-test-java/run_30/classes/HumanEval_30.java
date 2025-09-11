import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_30 {

    // Source Code Implementation
    public static class OriginalImpl {
        public static List<Integer> getPositive(List<Integer> l) {
            List<Integer> positiveList = new ArrayList<>();
            for (Integer e : l) {
                if (e > 0) {
                    positiveList.add(e);
                }
            }
            return positiveList;
        }
    }

    // Transformed Code Implementation
    public static class TransformedImpl {
        public static List<Integer> getPositive(List<Integer> l) {
            List<Integer> positiveNumbers = new ArrayList<>();
            int index = 0;

            while (index < l.size()) {
                if (l.get(index) > 0) {
                    positiveNumbers.add(l.get(index));
                }
                index++;
            }

            return positiveNumbers;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, -2, 3, 4, -5)),
            Arguments.of(List.of(-1, -2, -3, -4, -5)),
            Arguments.of(List.of(0, 0, 0, 0)),
            Arguments.of(List.of(10, 20, 30, 40, 50)),
            Arguments.of(List.of()),
            Arguments.of(List.of(-10, 0, 10)),
            Arguments.of(List.of(5)),
            Arguments.of(List.of(-5)),
            Arguments.of(List.of(1, 2, 3, 4, 5, -6, -7, -8, -9, -10)),
            Arguments.of(List.of(100, 200, 300, -100, -200, -300))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testGetPositive(List<Integer> input) {
        assertEquals(OriginalImpl.getPositive(input), TransformedImpl.getPositive(input));
    }
}