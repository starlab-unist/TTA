import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;  // Add this import for Stream
import java.util.Arrays;         // Add this import for Arrays

public class HumanEval_49 {

    // Source Code
    static class HumanEval_49_Source {
        public static int modp(int n, int p) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                ret = (2 * ret) % p;
            }
            return ret;
        }
    }

    // Transformed Code
    static class HumanEval_49_Transformed {
        public static int calculateModularExponentiation(int baseCount, int modulus) {
            int result = 1;
            int index = 0;
            while (index < baseCount) {
                result = (2 * result) % modulus;
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {0, 5},       // n=0, p=5
        {1, 3},       // n=1, p=3
        {2, 7},       // n=2, p=7
        {3, 4},       // n=3, p=4
        {5, 10},      // n=5, p=10
        {10, 13},     // n=10, p=13
        {20, 17},     // n=20, p=17
        {31, 31},     // n=31, p=31
        {50, 61},     // n=50, p=61
        {100, 97}     // n=100, p=97
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void modp_vs_calculateModularExponentiation(int n, int p) {
        assertEquals(
            HumanEval_49_Source.modp(n, p),
            HumanEval_49_Transformed.calculateModularExponentiation(n, p)
        );
    }
}