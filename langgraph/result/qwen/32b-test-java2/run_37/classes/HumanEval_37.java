import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_37 {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare sortEven and rearrangeEvenOdd methods")
    void sortEven_vs_rearrangeEvenOdd(List<Integer> inputList) {
        assertEquals(
            OriginalFunction.sortEven(inputList),
            new TransformedFunction().rearrangeEvenOdd(inputList)
        );
    }

    private static List<Arguments> provideTestCases() {
        return Arrays.asList(
            Arguments.of(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)), new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6))),
            Arguments.of(new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5)), new ArrayList<>(Arrays.asList(6, 9, 8, 7, 10, 5))),
            Arguments.of(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8)), new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5, 7, 6, 8))),
            Arguments.of(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(1, 2))),
            Arguments.of(new ArrayList<>(Arrays.asList(5)), new ArrayList<>(Arrays.asList(5))),
            Arguments.of(new ArrayList<>(), new ArrayList<>()),
            Arguments.of(new ArrayList<>(Arrays.asList(7, 1, 9, 3, 11, 5, 13)), new ArrayList<>(Arrays.asList(7, 1, 9, 3, 11, 5, 13))),
            Arguments.of(new ArrayList<>(Arrays.asList(4, 2, 6, 8, 0, 10, 12, 14)), new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14))),
            Arguments.of(new ArrayList<>(Arrays.asList(15, 14, 13, 12, 11, 10, 9)), new ArrayList<>(Arrays.asList(15, 10, 13, 12, 11, 14, 9))),
            Arguments.of(new ArrayList<>(Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28)), new ArrayList<>(Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28)))
        );
    }
}