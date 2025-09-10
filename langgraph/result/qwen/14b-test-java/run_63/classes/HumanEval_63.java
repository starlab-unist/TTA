import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_63 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
        public static int calculate_modified_fibonacci(int index) {
            if (index == 0) {
                return 0;
            } else if (index == 1) {
                return 0;
            } else if (index == 2) {
                return 1;
            } else {
                return (calculate_modified_fibonacci(index - 1) +
                        calculate_modified_fibonacci(index - 2) +
                        calculate_modified_fibonacci(index - 3));
            }
        }
    }

    // Test Cases
    @DisplayName("Test equivalence of fibfib and calculate_modified_fibonacci")
    @ParameterizedTest(name = "Test case {index} with input value {arguments}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void fibfib_vs_calculate_modified_fibonacci(int input) {
        assertEquals(
            SourceCode.fibfib(input),
            TransformedCode.calculate_modified_fibonacci(input)
        );
    }
}