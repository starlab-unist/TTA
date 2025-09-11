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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Stream;

public class HumanEval_39 {

    // Source Code
    static class OriginalImpl {
        public static BigInteger primeFib(int n) {
            ArrayList<BigInteger> f = new ArrayList<>();
            f.add(BigInteger.ZERO);
            f.add(BigInteger.ONE);

            while (true) {
                f.add(f.get(f.size() - 1).add(f.get(f.size() - 2)));
                if (isPrime(f.get(f.size() - 1))) {
                    n--;
                }
                if (n == 0) {
                    return f.get(f.size() - 1);
                }
            }
        }

        private static boolean isPrime(BigInteger p) {
            if (p.compareTo(BigInteger.valueOf(2)) < 0) {
                return false;
            }
            for (int k = 2; k <= Math.min((int) Math.sqrt(p.doubleValue()), p.intValue() - 1); k++) {
                if (p.mod(BigInteger.valueOf(k)).equals(BigInteger.ZERO)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static long findNthPrimeFibonacci(int n) {
            boolean[] prime = new boolean[n * 50]; // Adjust size as needed
            for (int i = 2; i < prime.length; i++) {
                prime[i] = true;
            }

            int count = 0;
            long a = 0, b = 1, c = 0;

            while (true) {
                c = a + b;
                a = b;
                b = c;

                if (isPrime(c, prime)) {
                    count++;
                    if (count == n) {
                        return c;
                    }
                }
            }
        }

        private static boolean isPrime(long number, boolean[] prime) {
            if (number < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (!prime[i]) continue;
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1, BigInteger.valueOf(2L)),
            Arguments.of(2, BigInteger.valueOf(3L)),
            Arguments.of(3, BigInteger.valueOf(5L)),
            Arguments.of(4, BigInteger.valueOf(13L)),
            Arguments.of(5, BigInteger.valueOf(89L)),
            Arguments.of(6, BigInteger.valueOf(233L)),
            Arguments.of(7, BigInteger.valueOf(1597L)),
            Arguments.of(8, BigInteger.valueOf(28657L)),
            Arguments.of(9, BigInteger.valueOf(514229L)),
            Arguments.of(10, BigInteger.valueOf(433494437L))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testPrimeFib(int n, BigInteger expected) {
        assertEquals(expected.longValue(), OriginalImpl.primeFib(n).longValue());
        assertEquals(expected.longValue(), TransformedImpl.findNthPrimeFibonacci(n));
    }
}