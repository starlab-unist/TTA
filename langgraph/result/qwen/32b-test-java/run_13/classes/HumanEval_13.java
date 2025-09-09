import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_13 {

    // Source Code
    static class HumanEval_13_Source {
        public static int greatestCommonDivisor(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    // Transformed Code
    static class HumanEval_13_Transformed {
        public static int findHighestCommonFactor(int num1, int num2) {
            while (num2 != 0) {
                int remainder = num1 % num2;
                num1 = num2;
                num2 = remainder;
            }
            return num1;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(48, 18),   // GCD is 6
        Arguments.of(56, 98),   // GCD is 14
        Arguments.of(101, 103), // GCD is 1 (prime numbers)
        Arguments.of(270, 192), // GCD is 6
        Arguments.of(0, 5),     // GCD is 5
        Arguments.of(5, 0),     // GCD is 5
        Arguments.of(0, 0),     // GCD is 0
        Arguments.of(20, 30),   // GCD is 10
        Arguments.of(7, 3),     // GCD is 1
        Arguments.of(100, 10)   // GCD is 10
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest(name = "Test case {index}: gcd({arguments})")
    @MethodSource("provideTestCases")
    void greatestCommonDivisor_vs_findHighestCommonFactor(int a, int b) {
        assertEquals(
            HumanEval_13_Source.greatestCommonDivisor(a, b),
            HumanEval_13_Transformed.findHighestCommonFactor(a, b)
        );
    }
}