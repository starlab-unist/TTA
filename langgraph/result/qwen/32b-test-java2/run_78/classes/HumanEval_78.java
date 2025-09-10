import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_78 {

    // Source Code
    static class SourceCode {
        public static int hexKey(String num) {  // Make the method static
            String[] primes = {"2", "3", "5", "7", "B", "D"};
            int total = 0;
            for (int i = 0; i < num.length(); i++) {
                if (contains(primes, String.valueOf(num.charAt(i)))) { // This will now work as 'contains' is static
                    total += 1;
                }
            }
            return total;
        }

        private static boolean contains(String[] array, String value) { // Make the method static
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
        public static int countPrimeHexDigits(String hexString) {  // Make the method static
            Set<Character> primeHexDigits = new HashSet<>(Set.of('2', '3', '5', '7', 'B', 'D'));
            int count = 0;
            for (int index = 0; index < hexString.length(); index++) {
                if (primeHexDigits.contains(hexString.charAt(index))) {
                    count += 1;
                }
            }
            return count;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"2"},          // Simple prime hex digit
        {"4"},          // Non-prime hex digit
        {"B"},          // Prime hex digit
        {"F"},          // Non-prime hex digit
        {"2357BD"},     // All prime hex digits
        {"168ACE"},     // No prime hex digits
        {"2B4D6F"},     // Mixed prime and non-prime hex digits
        {"0"},          // Edge case - no characters
        {"DEADBEEF"},   // Complex mixed case
        {"FFFFFFFF"}    // All non-prime hex digits
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test hexKey vs countPrimeHexDigits equivalence")
    void test_hexKey_vs_countPrimeHexDigits(String inputText) {
        assertEquals(
            SourceCode.hexKey(inputText),
            TransformedCode.countPrimeHexDigits(inputText)
        );
    }
}