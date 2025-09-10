import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_21 {

    private static final Double[][] testCases = {
        {1.0, 2.0, 3.0, 4.0, 5.0},
        {10.0, 20.0, 30.0, 40.0, 50.0},
        {5.0, 5.0, 5.0, 5.0},
        {-1.0, -2.0, -3.0, -4.0, -5.0},
        {0.0, 100.0},
        {3.14, 2.71, 1.618, 0.577},
        {100.0, 200.0, 300.0, 400.0, 500.0},
        {1.0, 1.0, 2.0, 2.0, 3.0, 3.0},
        {-5.0, 0.0, 5.0},
        {1000.0}
    };

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(values -> Arguments.of(new ArrayList<>(Arrays.asList(values))));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void rescaleToUnit_vs_normalizeValues(List<Double> inputList) {
        assertEquals(
            OriginalClass.rescaleToUnit(inputList),
            TransformedClass.normalizeValues(inputList)
        );
    }
}