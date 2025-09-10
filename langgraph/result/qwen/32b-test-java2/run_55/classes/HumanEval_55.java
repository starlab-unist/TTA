import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Necessary imports for Stream and Arrays
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_55 {

    // Source Code
    static class SourceCode {
        public static int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int calculateFibonacci(int sequenceIndex) {
            if (sequenceIndex == 0) {
                return 0;
            } else if (sequenceIndex == 1) {
                return 1;
            }

            int previous = 0, current = 1;
            int index = 2;
            while (index <= sequenceIndex) {
                int next = previous + current;
                previous = current;
                current = next;
                index++;
            }

            return current;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "fib({0}) == calculateFibonacci({0})")
    @MethodSource("provideTestCases")
    void fib_vs_calculateFibonacci(int input) {
        assertEquals(
            SourceCode.fib(input),
            TransformedCode.calculateFibonacci(input)
        );
    }
}