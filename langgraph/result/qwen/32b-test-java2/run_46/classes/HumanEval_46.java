import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Import missing Arrays utility
import java.util.stream.IntStream;  // Use IntStream for integer arrays
import java.util.stream.Stream;  // Import missing Stream interface

public class HumanEval_46 {

    // Source Code
    static class HumanEval_46 {
        public int fib4(int n) {  // This method is non-static
            int[] results = {0, 0, 2, 0};
            if (n < 4) {
                return results[n];
            }

            for (int i = 4; i <= n; i++) {
                int nextValue = results[0] + results[1] + results[2] + results[3];
                results[0] = results[1];
                results[1] = results[2];
                results[2] = results[3];
                results[3] = nextValue;
            }

            return results[3];
        }
    }

    // Transformed Code
    static class HumanEval_46_Transformed {
        public int calculateCustomFibonacci(int index) {  // This method is non-static
            int[] sequence = {0, 0, 2, 0};
            if (index < 4) {
                return sequence[index];
            }

            int currentIndex = 4;
            while (currentIndex <= index) {
                int nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
                sequence[0] = sequence[1];
                sequence[1] = sequence[2];
                sequence[2] = sequence[3];
                sequence[3] = nextValue;
                currentIndex++;
            }

            return sequence[3];
        }
    }


    // Test Cases
    private static final int[] testCases = {
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Base case
        4,  // First calculated value
        5,  // Continue calculation
        6,  // Continue calculation
        7,  // Continue calculation
        8,  // Continue calculation
        9   // Continue calculation
    };

    private static Stream<Arguments> provideTestCases() {
        return IntStream.of(testCases).boxed().map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index} with input {0}")
    @MethodSource("provideTestCases")
    void fib4_vs_calculateCustomFibonacci(int n) {
        // Create instances of the classes
        HumanEval_46 humanEval46 = new HumanEval_46();
        HumanEval_46_Transformed transformed = new HumanEval_46_Transformed();

        assertEquals(
            humanEval46.fib4(n),
            transformed.calculateCustomFibonacci(n)
        );
    }
}