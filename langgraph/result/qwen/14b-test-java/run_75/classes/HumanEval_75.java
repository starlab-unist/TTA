// Source Code
public static boolean isMultiplyPrime(int a) {
    for (int i = 2; i <= 100; i++) {
        if (!isPrime(i)) continue;
        for (int j = 2; j <= 100; j++) {
            if (!isPrime(j)) continue;
            for (int k = 2; k <= 100; k++) {
                if (!isPrime(k)) continue;
                if (i * j * k == a) return true;
            }
        }
    }
    return false;
}

private static boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int j = 2; j < n; j++) {
        if (n % j == 0) return false;
    }
    return true;
}

// Transformed Code
public static boolean checkProductOfThreePrimes(int number) {
    for (int first = 2; first <= 100; first++) {
        if (!isPrime(first)) continue;
        for (int second = 2; second <= 100; second++) {
            if (!isPrime(second)) continue;
            for (int third = 2; third <= 100; third++) {
                if (!isPrime(third)) continue;
                if (first * second * third == number) return true;
            }
        }
    }
    return false;
}

// Test Cases
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_75 {

    private static Stream<Arguments> provideTestCases() {
        int[] testCases = {
            30,   // 2*3*5
            60,   // 2*2*3*5 (False)
            105,  // 3*5*7
            231,  // 3*7*11
            385,  // 5*7*11
            500,  // 2*2*5*5*5 (False)
            770,  // 2*5*7*11 (False)
            969,  // 3*11*29
            1001, // 7*11*13
            1385  // 5*11*25 (False)
        };

        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index} with input: {arguments}")
    @MethodSource("provideTestCases")
    void isMultiplyPrime_vs_checkProductOfThreePrimes(int inputNumber) {
        assertEquals(
            isMultiplyPrime(inputNumber),
            checkProductOfThreePrimes(inputNumber)
        );
    }
}