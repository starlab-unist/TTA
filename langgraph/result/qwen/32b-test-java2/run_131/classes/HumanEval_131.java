import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Added import statement

public class HumanEval_131 {

    // Source Code
    static class HumanEval_131_Source {
        public static int digits(int n) {
            int product = 1;
            int oddCount = 0;
            String numberStr = Integer.toString(n);
            
            for (char digitChar : numberStr.toCharArray()) {
                int intDigit = Character.getNumericValue(digitChar);
                if (intDigit % 2 == 1) {
                    product *= intDigit;
                    oddCount++;
                }
            }
            
            if (oddCount == 0) {
                return 0;
            } else {
                return product;
            }
        }
    }

    // Transformed Code
    static class HumanEval_131_Transformed {
        public int calculateOddDigitProduct(int number) {
            int result = 1;
            int oddDigitsFound = 0;
            String numberStr = Integer.toString(number);
            
            for (int i = 0; i < numberStr.length(); i++) {
                int currentDigit = Character.getNumericValue(numberStr.charAt(i));
                if (currentDigit % 2 != 0) {
                    result *= currentDigit;
                    oddDigitsFound++;
                }
            }
            
            return oddDigitsFound > 0 ? result : 0;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {  // Changed int[] to Integer[]
        123456789,
        2468,
        13579,
        11111,
        0,
        987654321,
        2222222,
        123,
        555555,
        9
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);  // This line is now correct as Integer[] is being used
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void digits_vs_calculateOddDigitProduct(int inputNumber) {
        assertEquals(
            HumanEval_131_Source.digits(inputNumber),
            new HumanEval_131_Transformed().calculateOddDigitProduct(inputNumber)
        );
    }
}