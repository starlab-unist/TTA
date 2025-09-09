import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class HumanEval_78 {

    // Source Code
    static class SourceCode {
        public int hexKey(String num) {
            String[] primes = {"2", "3", "5", "7", "B", "D"};
            int total = 0;
            for (int i = 0; i < num.length(); i++) {
                if (contains(primes, String.valueOf(num.charAt(i)))) {
                    total += 1;
                }
            }
            return total;
        }

        private boolean contains(String[] array, String value) {
            for (String element : array) {
                if (element.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int countPrimeHexDigits(String hexString) {
            Set<Character> primeHexDigits = new HashSet<>(Set.of('2', '3', '5', '7', 'B', 'D'));
            int count = 0;
            int index = 0;
            while (index < hexString.length()) {
                if (primeHexDigits.contains(hexString.charAt(index))) {
                    count += 1;
                }
                index += 1;
            }
            return count;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "23456789ABCDEF",  // Contains primes: 2, 3, 5, 7, B, D (6 primes)
        "FFFFFFFF",        // No primes
        "1234567890",      // Contains primes: 2, 3, 5, 7 (4 primes)
        "BDBDBD",          // All are primes (6 primes)
        "222222",          // All are primes (6 primes)
        "777777",          // All are primes (6 primes)
        "",                // No primes
        "AEC",             // No primes
        "BEEF",            // Contains primes: B, E, E, F (1 prime)
        "DEADBEEF"         // Contains primes: D, B, E, E, F (2 primes)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test hexKey vs countPrimeHexDigits equivalence")
    void testEquivalence(String input) {
        assertEquals(
            new SourceCode().hexKey(input),
            new TransformedCode().countPrimeHexDigits(input)
        );
    }
}