import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Import statement added for Arrays class
import java.util.stream.Stream;

public class HumanEval_139 {

    // Source Code
    static class HumanEval_139_Source {
        public static long specialFactorial(int n) {
            long factI = 1;
            long specialFact = 1;
            for (int i = 1; i <= n; i++) {
                factI *= i;
                specialFact *= factI;
            }
            return specialFact;
        }
    }

    // Transformed Code
    static class HumanEval_139_Transformed {
        public long computeSpecialProduct(int n) {
            long currentFactorial = 1;
            long cumulativeProduct = 1;
            int index = 1;

            while (index <= n) {
                currentFactorial *= index;
                cumulativeProduct *= currentFactorial;
                index++;
            }

            return cumulativeProduct;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,      // Edge case: n = 0
        1,      // Simple case: n = 1
        2,      // Simple case: n = 2
        3,      // Simple case: n = 3
        4,      // Simple case: n = 4
        5,      // Simple case: n = 5
        6,      // Simple case: n = 6
        10,     // Larger number: n = 10
        20,     // Larger number: n = 20
        100     // Very large number: n = 100
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Input {index}: {0}")
    @MethodSource("provideTestCases")
    public void specialFactorial_vs_computeSpecialProduct(int input) {
        assertEquals(
            HumanEval_139_Source.specialFactorial(input),
            new HumanEval_139_Transformed().computeSpecialProduct(input)
        );
    }
}