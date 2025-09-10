import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_62 {

    // Source Code with static method
    static class SourceCode {
        public static List<Integer> derivative(List<Integer> xs) {  // Changed to static
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < xs.size(); i++) {
                result.add(i * xs.get(i));
            }
            return result;
        }
    }

    // Transformed Code with static method
    static class TransformedCode {
        public static List<Integer> computeDerivative(List<Integer> coefficients) {  // Changed to static
            List<Integer> result = new ArrayList<>();
            int index = 1;
            while (index < coefficients.size()) {
                result.add(index * coefficients.get(index));
                index++;
            }
            return result;
        }
    }

    // Test Cases with expected outputs included
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(3, 1, 2, 4), Arrays.asList(1, 4, 12)),       // Expected output: [1, 4, 12]
        Arguments.of(Arrays.asList(0, 5, 0, 7), Arrays.asList(5, 0, 21)),       // Expected output: [5, 0, 21]
        Arguments.of(Arrays.asList(1, 3, 5, 7, 9), Arrays.asList(3, 10, 21, 36)),    // Expected output: [3, 10, 21, 36]
        Arguments.of(Arrays.asList(2, 0, 0, 0), Arrays.asList(0, 0, 0)),       // Expected output: [0, 0, 0]
        Arguments.of(Arrays.asList(10, 20, 30), Arrays.asList(20, 60)),       // Expected output: [20, 60]
        Arguments.of(Arrays.asList(5), new ArrayList<>()),                // Expected output: []
        Arguments.of(new ArrayList<>(), new ArrayList<>() ),                 // Expected output: []
        Arguments.of(Arrays.asList(1, -1, 1, -1), Arrays.asList(-1, 2, -3)),     // Expected output: [-1, 2, -3]
        Arguments.of(Arrays.asList(0, 0, 0, 0, 0), Arrays.asList(0, 0, 0, 0)),    // Expected output: [0, 0, 0, 0]
        Arguments.of(Arrays.asList(7, 6, 5, 4, 3, 2), Arrays.asList(6, 10, 12, 12, 10))  // Expected output: [6, 10, 12, 12, 10]
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void derivative_vs_computeDerivative(List<Integer> input, List<Integer> expected) {
        assertEquals(
            SourceCode.derivative(input),
            TransformedCode.computeDerivative(input),
            "Failed for input: " + input
        );
        assertEquals(expected, 
                     SourceCode.derivative(input), 
                     "Source code failed for input: " + input);
        assertEquals(expected,
                     TransformedCode.computeDerivative(input),
                     "Transformed code failed for input: " + input);
    }
}