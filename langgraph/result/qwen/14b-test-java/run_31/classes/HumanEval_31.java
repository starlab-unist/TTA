import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream; // Added import for Stream
import java.util.Arrays; // Added import for Arrays

public class HumanEval_31 {

    // Source Code
    static class SourceCode {
        public static boolean is_prime(int n) {
            if (n < 2) {
                return false;
            }
            for (int k = 2; k < n - 1; k++) {
                if (n % k == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean check_prime(int number) {
            if (number < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor < number - 1) {
                if (number % divisor == 0) {
                    return false;
                }
                divisor += 1;
            }
            return true;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,      // Not prime (less than 2)
        1,      // Not prime (less than 2)
        2,      // Prime
        3,      // Prime
        4,      // Not prime
        5,      // Prime
        9,      // Not prime
        11,     // Prime
        16,     // Not prime
        17,     // Prime
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void is_prime_vs_check_prime(int inputNumber) {
        assertEquals(
            SourceCode.is_prime(inputNumber),
            TransformedCode.check_prime(inputNumber)
        );
    }
}