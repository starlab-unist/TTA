import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class OriginalImpl {
    public List<Integer> getPositive(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : l) {
            if (e > 0) {
                result.add(e);
            }
        }
        return result;
    }
}

// Transformed Code
class TransformedImpl {
    public List<Integer> extractPositiveNumbers(List<Integer> inputList) {
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

// Test Class
public class HumanEval_30 {

    // Provide test cases as a Stream of Arguments
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1, -2, 3, 4, -5)), new ArrayList<>(Arrays.asList(1, 3, 4))),
            Arguments.of(new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5)), new ArrayList<>()),
            Arguments.of(new ArrayList<>(Arrays.asList(0, 0, 0, 0)), new ArrayList<>()),
            Arguments.of(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)), new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50))),
            Arguments.of(new ArrayList<>(), new ArrayList<>()),
            Arguments.of(new ArrayList<>(Arrays.asList(-10, 0, 10)), new ArrayList<>(Arrays.asList(10))),
            Arguments.of(new ArrayList<>(Arrays.asList(5)), new ArrayList<>(Arrays.asList(5))),
            Arguments.of(new ArrayList<>(Arrays.asList(-5)), new ArrayList<>()),
            Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10)), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))),
            Arguments.of(new ArrayList<>(Arrays.asList(100, 200, 300, -100, -200, -300)), new ArrayList<>(Arrays.asList(100, 200, 300)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testGetPositive(List<Integer> input, List<Integer> expected) {
        assertEquals(new OriginalImpl().getPositive(input), 
                     new TransformedImpl().extractPositiveNumbers(input));
    }
}