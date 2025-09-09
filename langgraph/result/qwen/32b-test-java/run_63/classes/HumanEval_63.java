import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_63 {

    // Source Code
    static class HumanEval_63 {
        public static int fibfib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3);
        }
    }

    // Transformed Code
    static class HumanEval_63_Transformed {
        public int calculateModifiedFibonacci(int index) {
            if (index == 0) {
                return 0;
            } else if (index == 1) {
                return 0;
            } else if (index == 2) {
                return 1;
            } else {
                return (calculateModifiedFibonacci(index - 1) +
                        calculateModifiedFibonacci(index - 2) +
                        calculateModifiedFibonacci(index - 3));
            }
        }
    }

    // Test Cases
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19})
    @DisplayName("Fibfib vs calculateModifiedFibonacci")
    void fibfib_vs_calculateModifiedFibonacci(int input) {
        assertEquals(
            HumanEval_63.fibfib(input),
            new HumanEval_63_Transformed().calculateModifiedFibonacci(input)
        );
    }
}