import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
static class SourceCode {
    public static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                fact.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            fact.add(n);
        }
        return fact;
    }
}

// Transformed Code
static class TransformedCode {
    public static List<Integer> decomposeNumber(int number) {
        List<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                factors.add(divisor);
                number /= divisor;
            } else {
                divisor += 1;
            }
        }

        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}

// Test Cases
public class HumanEval_25 {

    private static final int[] testCases = {
        1,   // Test with the smallest prime number
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        15,  // Test with a composite number
        16,  // Power of two
        17,  // Prime number larger than the previous ones
        18,  // Composite number with repeated factors
        20   // Another composite number
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).boxed().map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}: factorize({0}) vs decomposeNumber({0})")
    @MethodSource("provideTestCases")
    void factorize_vs_decomposeNumber(int input) {
        assertEquals(
            SourceCode.factorize(input),
            TransformedCode.decomposeNumber(input)
        );
    }
}