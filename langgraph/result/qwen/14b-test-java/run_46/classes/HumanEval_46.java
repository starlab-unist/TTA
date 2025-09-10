import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

// Source Code
static class SourceCode {
    public static int fib4(int n) {
        int[] results = {0, 0, 2, 0};
        if (n < 4) {
            return results[n];
        }

        for (int i = 4; i <= n; i++) {
            int nextValue = results[3] + results[2] + results[1] + results[0];
            results[0] = results[1];
            results[1] = results[2];
            results[2] = results[3];
            results[3] = nextValue;
        }

        return results[3];
    }
}

// Transformed Code
static class TransformedCode {
    public static int calculateCustomFibonacci(int index) {
        int[] sequence = {0, 0, 2, 0};
        if (index < 4) {
            return sequence[index];
        }

        int currentIndex = 4;
        while (currentIndex <= index) {
            int nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
            for (int i = 0; i < 3; i++) {
                sequence[i] = sequence[i + 1];
            }
            sequence[3] = nextValue;
            currentIndex++;
        }

        return sequence[3];
    }
}

// Test Cases
public class HumanEval_46 {

    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).mapToObj(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void fib4_vs_calculateCustomFibonacci(int input) {
        assertEquals(
            SourceCode.fib4(input),
            TransformedCode.calculateCustomFibonacci(input)
        );
    }
}