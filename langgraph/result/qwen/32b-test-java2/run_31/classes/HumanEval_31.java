{source_code}
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_31 {

    // Source Code
    static class SourceCode {
        public boolean isPrime(int n) {
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
        public boolean checkPrime(int number) {
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

    @DisplayName("Check equivalence of isPrime and checkPrime functions")
    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("provideTestCases")
    void testIsPrime_vs_checkPrime(int inputNumber) {
        SourceCode sourceInstance = new SourceCode();
        TransformedCode transformedInstance = new TransformedCode();

        assertEquals(
            sourceInstance.isPrime(inputNumber),
            transformedInstance.checkPrime(inputNumber)
        );
    }
}
{transformed_code}
// This is the Transformed Code class, part of the test setup.
static class TransformedCode {
    public boolean checkPrime(int number) {
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
{test_cases}
// This is the Test Cases section, part of the test setup.
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