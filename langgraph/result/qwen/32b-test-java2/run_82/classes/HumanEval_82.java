import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_82 {

    // Source Code
    static class SourceCode {
        public boolean primeLength(String string) {
            int l = string.length();
            if (l == 0 || l == 1) {
                return false;
            }
            for (int i = 2; i < l; i++) {
                if (l % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkPrimeStringLength(String inputText) {
            int stringLength = inputText.length();
            if (stringLength < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor < stringLength) {
                if (stringLength % divisor == 0) {
                    return false;
                }
                divisor++;
            }
            return true;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "a",
        "ab",
        "abc",
        "abcd",
        "abcde",
        "abcdef",
        "abcdefgh",
        "abcdefghi",
        "abcdefghij"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("primeLength vs checkPrimeStringLength")
    void primeLength_vs_checkPrimeStringLength(String inputText) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();
        assertEquals(
            source.primeLength(inputText),
            transformed.checkPrimeStringLength(inputText)
        );
    }
}