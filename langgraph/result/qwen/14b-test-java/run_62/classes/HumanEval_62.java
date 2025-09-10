import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Added import statement for Stream

public class HumanEval_62 {

    // Source Code
    static class SourceCode {
        public static List<Integer> derivative(List<Integer> xs) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < xs.size(); i++) {
                result.add(i * xs.get(i));
            }
            return result.subList(1, result.size());
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> computeDerivative(List<Integer> coefficients) {
            List<Integer> result = new ArrayList<>();
            int index = 1;
            while (index < coefficients.size()) {
                result.add(index * coefficients.get(index));
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(3, 1, 2, 4),       // Expected output: [1, 4, 12]
        Arrays.asList(0, 5, 0, 7),       // Expected output: [5, 0, 21]
        Arrays.asList(1, 3, 5, 7, 9),    // Expected output: [3, 10, 21, 36]
        Arrays.asList(2, 0, 0, 0),       // Expected output: [0, 0, 0]
        Arrays.asList(10, 20, 30),       // Expected output: [20, 60]
        Arrays.asList(5),                // Expected output: []
        Arrays.asList(),                 // Expected output: []
        Arrays.asList(1, -1, 1, -1),     // Expected output: [-1, 2, -3]
        Arrays.asList(0, 0, 0, 0, 0),    // Expected output: [0, 0, 0, 0]
        Arrays.asList(7, 6, 5, 4, 3, 2)  // Expected output: [6, 10, 12, 12, 10]
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @DisplayName("Check if source and transformed code produce the same output")
    @ParameterizedTest(name = "Test case {index}: {0}")
    @MethodSource("provideTestCases")
    void derivative_vs_computeDerivative(List<Integer> input) {
        assertEquals(
            SourceCode.derivative(input),
            TransformedCode.computeDerivative(input)
        );
    }
}