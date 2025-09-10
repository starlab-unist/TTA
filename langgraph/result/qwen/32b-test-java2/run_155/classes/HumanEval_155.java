import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_155 {

    // Source Code
    static class HumanEval_155_Source {
        public static int[] evenOddCount(int num) {
            int evenCount = 0;
            int oddCount = 0;
            String numberStr = Integer.toString(Math.abs(num));
            for (char c : numberStr.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            return new int[]{evenCount, oddCount};
        }
    }

    // Transformed Code
    static class HumanEval_155_Transformed {
        public static int[] tallyEvenOddDigits(int number) {
            int evenTally = 0;
            int oddTally = 0;
            int index = 0;
            String numStr = Integer.toString(Math.abs(number));
            
            while (index < numStr.length()) {
                int digit = Character.getNumericValue(numStr.charAt(index));
                if (digit % 2 == 0) {
                    evenTally += 1;
                } else {
                    oddTally += 1;
                }
                index += 1;
            }
            
            return new int[]{evenTally, oddTally};
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        1234567890,
        -1234567890,
        24680,
        13579,
        0,
        111222333,
        987654321,
        -987654321,
        1000000,
        1
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of evenOddCount and tallyEvenOddDigits functions")
    void evenOddCount_vs_tallyEvenOddDigits(Integer inputNumber) { 
        int[] resultOriginal = HumanEval_155_Source.evenOddCount(inputNumber);
        int[] resultTransformed = HumanEval_155_Transformed.tallyEvenOddDigits(inputNumber);

        assertEquals(
            resultOriginal[0], 
            resultTransformed[0],
            "Even counts do not match for input: " + inputNumber
        );

        assertEquals(
            resultOriginal[1], 
            resultTransformed[1],
            "Odd counts do not match for input: " + inputNumber
        );
    }
}