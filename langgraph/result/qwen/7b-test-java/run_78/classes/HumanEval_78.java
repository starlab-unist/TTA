import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_78 {

    // Source Code
    public static class OriginalImpl {
        public static int hexKey(String num) {
            char[] primes = {'2', '3', '5', '7', 'B', 'D'};
            int total = 0;
            for (int i = 0; i < num.length(); i++) {
                if (isPrime(num.charAt(i), primes)) {
                    total++;
                }
            }
            return total;
        }

        private static boolean isPrime(char ch, char[] primes) {
            for (char prime : primes) {
                if (ch == prime) {
                    return true;
                }
            }
            return false;
        }
    }

    // Transformed Code
    public static class TransformedImpl {
        public static int countPrimeHexDigits(String hexString) {
            java.util.Set<Character> primeHexDigits = new java.util.HashSet<>(java.util.Arrays.asList('2', '3', '5', '7', 'B', 'D'));
            int count = 0;
            int index = 0;
            while (index < hexString.length()) {
                if (primeHexDigits.contains(hexString.charAt(index))) {
                    count++;
                }
                index++;
            }
            return count;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("23456789ABCDEF"),
            Arguments.of("FFFFFFFF"),
            Arguments.of("1234567890"),
            Arguments.of("BDBDBD"),
            Arguments.of("222222"),
            Arguments.of("777777"),
            Arguments.of(""),
            Arguments.of("AEC"),
            Arguments.of("BEEF"),
            Arguments.of("DEADBEEF")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testHexKeyAndCountPrimeHexDigits(String input) {
        assertEquals(OriginalImpl.hexKey(input), TransformedImpl.countPrimeHexDigits(input));
    }
}