{source_code}
static class SourceCode {
    public static int hexKey(String num) {
        String[] primes = {"2", "3", "5", "7", "B", "D"};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            for (String prime : primes) {
                if (Character.toString(num.charAt(i)).equals(prime)) {
                    total += 1;
                    break;
                }
            }
        }
        return total;
    }
}

{transformed_code}
static class TransformedCode {
    public static int countPrimeHexDigits(String hexString) {
        String primeHexDigits = "2357BD";
        int count = 0;
        int index = 0;
        while (index < hexString.length()) {
            if (primeHexDigits.indexOf(hexString.charAt(index)) != -1) {
                count += 1;
            }
            index += 1;
        }
        return count;
    }
}

{test_cases}
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays; // Added import statement

public class HumanEval_78 {

    private static final String[] testCases = {
        "2",      // Single prime hex digit
        "3",      // Single prime hex digit
        "5",      // Single prime hex digit
        "7",      // Single prime hex digit
        "B",      // Single prime hex digit
        "D",      // Single prime hex digit
        "F",      // Non-prime hex digit
        "123456", // Mixed digits including prime and non-prime
        "",       // Empty string
        "BDDBDB"  // Repeated prime hex digits
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void hexKey_vs_countPrimeHexDigits(String inputText) {
        assertEquals(
            SourceCode.hexKey(inputText),
            TransformedCode.countPrimeHexDigits(inputText)
        );
    }
}