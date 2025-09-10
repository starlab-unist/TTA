// Required imports must be placed here at the beginning of the file.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

// Source Code
class HumanEval_49 {

    static class SourceCode {
        public static int modp(int n, int p) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                ret = (2 * ret) % p;
            }
            return ret;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateModularExponentiation(int baseCount, int modulus) {
            int result = 1;
            int index = 0;
            while (index < baseCount) {
                result = (2 * result) % modulus;
                index += 1;
            }
            return result;
        }
    }

    private static final Arguments[][] testCases = {
        {Arguments.of(0, 5)},       // n=0, p=5
        {Arguments.of(1, 3)},       // n=1, p=3
        {Arguments.of(2, 7)},       // n=2, p=7
        {Arguments.of(3, 4)},       // n=3, p=4
        {Arguments.of(5, 10)},      // n=5, p=10
        {Arguments.of(10, 13)},     // n=10, p=13
        {Arguments.of(20, 17)},     // n=20, p=17
        {Arguments.of(31, 31)},     // n=31, p=31
        {Arguments.of(50, 61)},     // n=50, p=61
        {Arguments.of(100, 97)}    // n=100, p=97
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest(name = "Test Case {index}: modp({0}, {1})")
    @MethodSource("provideTestCases")
    void testModp_vs_calculateModularExponentiation(int n, int p) {
        assertEquals(
            SourceCode.modp(n, p),
            new TransformedCode().calculateModularExponentiation(n, p)
        );
    }
}