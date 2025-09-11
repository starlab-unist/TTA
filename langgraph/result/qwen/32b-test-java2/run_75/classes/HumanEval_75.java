import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code Wrapped as Nested Static Class
static class OriginalImpl {
    public static boolean isMultiplyPrime(int a) {
        return isMultiplyPrimeHelper(a);
    }

    private static boolean isMultiplyPrimeHelper(int a) {
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
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}

// Transformed Code Wrapped as Nested Static Class
static class TransformedImpl {
    public static boolean checkProductOfThreePrimes(int number) {
        for (int first : primeRange()) {
            if (!primeCheck(first)) {
                continue;
            }
            for (int second : primeRange()) {
                if (!primeCheck(second)) {
                    continue;
                }
                for (int third : primeRange()) {
                    if (!primeCheck(third)) {
                        continue;
                    }
                    if (first * second * third == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean primeCheck(int value) {
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] primeRange() {
        int[] range = new int[99];
        for (int i = 0; i < range.length; i++) {
            range[i] = i + 2;
        }
        return range;
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_75 {

    // Test Cases
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(30),   // 2*3*5
            Arguments.of(60),   // 2*2*3*5 (False)
            Arguments.of(105),  // 3*5*7
            Arguments.of(231),  // 3*7*11
            Arguments.of(385),  // 5*7*11
            Arguments.of(500),  // 2*2*5*5*5 (False)
            Arguments.of(770),  // 2*5*7*11 (False)
            Arguments.of(969),  // 3*11*29
            Arguments.of(1001), // 7*11*13
            Arguments.of(1385)  // 5*11*25 (False)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int input) {
        assertEquals(OriginalImpl.isMultiplyPrime(input), TransformedImpl.checkProductOfThreePrimes(input));
    }
}