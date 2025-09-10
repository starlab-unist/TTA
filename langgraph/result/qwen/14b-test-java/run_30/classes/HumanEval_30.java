import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_30 {

    // Source Code
    static class SourceCode {
        public static List<Integer> getPositive(List<Integer> l) {
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
    static class TransformedCode {
        public static List<Integer> extract_positive_numbers(List<Integer> input_list) {
            List<Integer> positive_numbers = new ArrayList<>();
            int index = 0;

            while (index < input_list.size()) {
                if (input_list.get(index) > 0) {
                    positive_numbers.add(input_list.get(index));
                }
                index++;
            }

            return positive_numbers;
        }
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(1, -2, 3, 4, -5),
        Arrays.asList(-1, -2, -3, -4, -5),
        Arrays.asList(0, 0, 0, 0),
        Arrays.asList(10, 20, 30, 40, 50),
        Arrays.asList(),
        Arrays.asList(-10, 0, 10),
        Arrays.asList(5),
        Arrays.asList(-5),
        Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10),
        Arrays.asList(100, 200, 300, -100, -200, -300)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @DisplayName("Test getPositive vs extract_positive_numbers")
    @ParameterizedTest(name = "Test case #{index}")
    @MethodSource("provideTestCases")
    void testGetPositive_vs_extractPositiveNumbers(List<Integer> inputList) {
        assertEquals(
            SourceCode.getPositive(inputList),
            TransformedCode.extract_positive_numbers(inputList)
        );
    }
}