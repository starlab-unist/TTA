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

public class HumanEval_150 {

    // Source Code
    static class OriginalImpl {
        public static int xOrY(int n, int x, int y) {
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
        public int determineValueBasedOnDivisibility(int n, int x, int y) {
            if (n == 1) {
                return y;
            }

            int divisor = 2;
            while (divisor < n) {
                if (n % divisor == 0) {
                    return y;
                }
                divisor++;
            }
            return x;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1, 5, 10),
            Arguments.of(2, 7, 3),
            Arguments.of(3, 8, 4),
            Arguments.of(4, 9, 6),
            Arguments.of(5, 11, 2),
            Arguments.of(6, 12, 1),
            Arguments.of(7, 13, 5),
            Arguments.of(8, 14, 7),
            Arguments.of(9, 15, 3),
            Arguments.of(10, 16, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testImplementations(int n, int x, int y) {
        assertEquals(OriginalImpl.xOrY(n, x, y), new TransformedImpl().determineValueBasedOnDivisibility(n, x, y));
    }
}