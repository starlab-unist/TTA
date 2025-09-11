import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_30 {

    // Original Implementation
    public static class OriginalImpl {
        public static List<Integer> getPositive(List<Integer> l) {
            return l.stream().filter(e -> e > 0).collect(Collectors.toList());
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static List<Integer> extractPositiveNumbers(List<Integer> inputList) {
            List<Integer> positiveNumbers = new ArrayList<>();
            int index = 0;

            while (index < inputList.size()) {
                if (inputList.get(index) > 0) {
                    positiveNumbers.add(inputList.get(index));
                }
                index++;
            }

            return positiveNumbers;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, -2, 3, 4, -5), Arrays.asList(1, 3, 4)),
            Arguments.of(Arrays.asList(-1, -2, -3, -4, -5), new ArrayList<>()),
            Arguments.of(Arrays.asList(0, 0, 0, 0), new ArrayList<>()),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 50), Arrays.asList(10, 20, 30, 40, 50)),
            Arguments.of(new ArrayList<>(), new ArrayList<>()),
            Arguments.of(Arrays.asList(-10, 0, 10), Arrays.asList(10)),
            Arguments.of(Arrays.asList(5), Arrays.asList(5)),
            Arguments.of(Arrays.asList(-5), new ArrayList<>()),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10), Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(100, 200, 300, -100, -200, -300), Arrays.asList(100, 200, 300))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testGetPositive(List<Integer> input, List<Integer> expected) {
        assertEquals(OriginalImpl.getPositive(input), TransformedImpl.extractPositiveNumbers(input));
    }
}