import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_138 {

    // Source Code
    static class SourceCode {
        public boolean isEqualToSumEven(int n) {
            return n % 2 == 0 && n >= 8;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkEvenAndMinimumEight(int number) {
            return number % 2 == 0 && number >= 8;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {4, false},
        {6, false},
        {8, true},
        {10, true},
        {12, true},
        {7, false},
        {9, false},
        {0, false},
        {-2, false},
        {(int) 8.0, true},  // Edge case: float that is an integer
        {(int) 10.5, false}  // Edge case: non-integer float (cast to int)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isEqualToSumEven_vs_checkEvenAndMinimumEight(int input, boolean expected) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.isEqualToSumEven(input),
            transformed.checkEvenAndMinimumEight(input)
        );
    }
}