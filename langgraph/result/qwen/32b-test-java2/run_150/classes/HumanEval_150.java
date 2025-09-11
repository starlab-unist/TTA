import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_150 {

    // Original Code
    static class OriginalImpl {
        public static Object xOrY(int n, int x, int y) {
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
    static class TransformedImpl {
        public static Object determineValueBasedOnDivisibility(int number, int valueIfNotPrime, int valueIfPrime) {
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
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1, 10, 20),
            Arguments.of(2, 10, 20),
            Arguments.of(3, 10, 20),
            Arguments.of(4, 10, 20),
            Arguments.of(5, 10, 20),
            Arguments.of(6, 10, 20),
            Arguments.of(7, 10, 20),
            Arguments.of(8, 10, 20),
            Arguments.of(9, 10, 20),
            Arguments.of(10, 10, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int n, int x, int y) {
        assertEquals(OriginalImpl.xOrY(n, x, y), TransformedImpl.determineValueBasedOnDivisibility(n, x, y));
    }
}