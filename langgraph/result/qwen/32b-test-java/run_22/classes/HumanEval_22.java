import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_22 {

    // Source Code
    static class HumanEval_22_Source {
        public List<Integer> filterIntegers(List<Object> values) {
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
    static class HumanEval_22_Transformed {
        public List<Integer> extractIntegers(List<Object> data) {
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
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3.5, "a", 4)},
        {Arrays.asList("hello", 100, 200, "world")},
        {Arrays.asList(1, 2, 3, 4, 5)},
        {Arrays.asList("x", "y", "z")},
        {Arrays.asList(null, true, false, 0, 1)},
        {Collections.emptyList()},
        {Arrays.asList(1.1, 2.2, 3.3)},
        {Arrays.asList(1, "1", 2, "2", 3, "3")},
        {Arrays.asList(0, -1, -2, 3, 4)},
        {Arrays.asList("test", 123, "example", 456)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("filterIntegers vs extractIntegers")
    void filterIntegers_vs_extractIntegers(List<Object> input) {
        assertEquals(
            new HumanEval_22_Source().filterIntegers(input),
            new HumanEval_22_Transformed().extractIntegers(input)
        );
    }
}