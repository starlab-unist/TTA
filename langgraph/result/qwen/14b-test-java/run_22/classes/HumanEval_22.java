// SourceCode.java (or combined with other classes in a single file)
import java.util.ArrayList;
import java.util.List;

class SourceCode {
    public static List<Integer> filterIntegers(List<Object> values) {
        List<Integer> integers = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof Integer) {
                integers.add((Integer) value);
            }
        }
        return integers;
    }
}

// TransformedCode.java (or combined with other classes in a single file)
class TransformedCode {
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

// EquivTest.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_22 {

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3.5, 'a', 4)},
        {Arrays.asList("hello", 100, 200, "world")},
        {Arrays.asList(1, 2, 3, 4, 5)},
        {Arrays.asList('x', 'y', 'z')},
        {Arrays.asList(null, true, false, 0, 1)},
        {new ArrayList<>()},
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
    @DisplayName("Test filterIntegers vs extractIntegers")
    void filterIntegers_vs_extractIntegers(List<Object> input) {
        assertEquals(
            SourceCode.filterIntegers(input),
            TransformedCode.extractIntegers(input)
        );
    }
}