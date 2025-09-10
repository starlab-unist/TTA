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

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
        {Arrays.asList(1, 2, 3.5, "a", 4)},       // Mixed types including Integer and non-integer
        {Arrays.asList("hello", 100, 200, "world")}, // Strings and integers
        {Arrays.asList(1, 2, 3, 4, 5)},            // Only integers
        {Arrays.asList("x", "y", "z")},              // Only strings
        {Arrays.asList(null, true, false, 0, 1)},    // Mixed types with null and booleans
        {Arrays.asList()},                            // Empty list
        {Arrays.asList(1.1, 2.2, 3.3)},              // Only doubles
        {Arrays.asList(1, "1", 2, "2", 3, "3")},    // Integers and strings with same numbers
        {Arrays.asList(0, -1, -2, 3, 4)},          // Negative integers and zero
        {Arrays.asList("test", 123, "example", 456)} // Strings and integers in an alternating pattern
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of filterIntegers and extractIntegers")
    void filterIntegers_vs_extractIntegers(List<Object> inputValues) {
        assertEquals(
            SourceCode.filterIntegers(inputValues),
            new TransformedCode().extractIntegers(inputValues)
        );
    }
}