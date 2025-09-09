import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HumanEval_150 {

    // Source Code
    static class SourceCode {
        public static int xOrY(int n, int x, int y) {
            if (n == 1) {
                return y;
            }
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return y;
                }
            }
            return x;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static Object determineValueBasedOnDivisibility(int number, Object valueIfNotPrime, Object valueIfPrime) {
            if (number == 1) {
                return valueIfPrime;
            }

            int divisor = 2;
            while (divisor < number) {
                if (number % divisor == 0) {
                    return valueIfPrime;
                }
                divisor += 1;
            }
            return valueIfNotPrime;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(1, "not_prime", "prime"),
        Arguments.of(2, "not_prime", "prime"),
        Arguments.of(3, "not_prime", "prime"),
        Arguments.of(4, "not_prime", "prime"),
        Arguments.of(5, "not_prime", "prime"),
        Arguments.of(6, "not_prime", "prime"),
        Arguments.of(7, "not_prime", "prime"),
        Arguments.of(8, "not_prime", "prime"),
        Arguments.of(9, "not_prime", "prime"),
        Arguments.of(10, "not_prime", "prime")
    };

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void xOrY_vs_determineValueBasedOnDivisibility(int n, String valueIfNotPrime, String valueIfPrime) {
        assertEquals(
            SourceCode.xOrY(n, 0, 1),
            TransformedCode.determineValueBasedOnDivisibility(n, valueIfNotPrime, valueIfPrime).equals("prime") ? 1 : 0
        );
    }
}