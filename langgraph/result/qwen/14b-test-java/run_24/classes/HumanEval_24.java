// SourceCode.java (assuming it's in the same package or imported correctly)
public class HumanEval_24 {
    public static int largestDivisor(int n) {
        if (n <= 1) return n;
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

// TransformedCode.java (assuming it's in the same package or imported correctly)
public class TransformedCode {
    public static int findGreatestDivisor(int n) {
        if (n <= 1) return n;
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

// HumanEval_24_Test.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;

// Importing SourceCode and TransformedCode classes (assuming they are in the same package)
// If they are not, replace with the correct package path
import SourceCode;
import TransformedCode;

public class HumanEval_24_Test {

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(1, 1)},       // Edge case: no divisors for 1 (original function will return 1)
        {Arguments.of(2, 1)},
        {Arguments.of(3, 1)},
        {Arguments.of(4, 2)},
        {Arguments.of(5, 1)},
        {Arguments.of(6, 3)},
        {Arguments.of(10, 5)},
        {Arguments.of(15, 5)},
        {Arguments.of(20, 10)},
        {Arguments.of(25, 5)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arrays::stream).flatMap(Stream::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void largestDivisor_vs_findGreatestDivisor(int inputNumber, int expectedOutput) {
        assertEquals(
            SourceCode.largestDivisor(inputNumber),
            TransformedCode.findGreatestDivisor(inputNumber)
        );
    }
}