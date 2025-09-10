// Source Code
class SourceCode {
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
class TransformedCode {
    public static int calculate_fibonacci(int sequence_index) {
        if (sequence_index == 0) {
            return 0;
        } else if (sequence_index == 1) {
            return 1;
        }

        int previous = 0, current = 1;
        int index = 2;
        while (index <= sequence_index) {
            int next = current + previous;
            previous = current;
            current = next;
            index++;
        }

        return current;
    }
}

// JUnit Test Cases
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Necessary imports for Stream and Arrays
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_55 {

    // Test Cases
    private static final int[] testCases = {
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
        return Arrays.stream(testCases).map(n -> Arguments.of(n));
    }

    @ParameterizedTest(name = "Test case {index}: n = {arguments}")
    @MethodSource("provideTestCases")
    void fib_vs_calculate_fibonacci(int input) {
        assertEquals(
            SourceCode.fib(input),
            TransformedCode.calculate_fibonacci(input)
        );
    }
}