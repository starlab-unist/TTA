import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Original Implementation
class HumanEval_108 {

    public static class OriginalImpl {
        public static int countNums(int[] arr) {
            return (int) Arrays.stream(arr)
                    .mapToInt(OriginalImpl::digitsSum)
                    .filter(i -> i > 0)
                    .count();
        }

        public static int digitsSum(int n) {
            boolean neg = n < 0;
            n = Math.abs(n);
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return neg ? -sum : sum;
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static int tallyPositiveDigitSums(int[] numbers) {
            int positiveSumsCount = 0;

            for (int num : numbers) {
                if (computeDigitSum(num) > 0) {
                    positiveSumsCount++;
                }
            }

            return positiveSumsCount;
        }

        public static int computeDigitSum(int number) {
            int sign = number < 0 ? -1 : 1;
            int absoluteValue = Math.abs(number);
            int[] digitList = new int[Integer.toString(absoluteValue).length()];

            for (int i = 0; i < digitList.length; i++) {
                digitList[i] = Character.getNumericValue(Integer.toString(absoluteValue).charAt(i));
            }

            digitList[0] *= sign;
            return Arrays.stream(digitList).sum();
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{123, -456, 789}),
                Arguments.of(new int[]{-111, 222, -333, 444}),
                Arguments.of(new int[]{0, 0, 0}),
                Arguments.of(new int[]{-1, 1, -1, 1}),
                Arguments.of(new int[]{999, -888, 777, -666}),
                Arguments.of(new int[]{1001, 2002, -3003, 4004}),
                Arguments.of(new int[]{-5, 5, -5, 5, -5}),
                Arguments.of(new int[]{10, -20, 30, -40, 50}),
                Arguments.of(new int[]{987654321, -123456789}),
                Arguments.of(new int[]{-12345, 12345, -12345})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testImplementations(int[] input) {
        assertEquals(OriginalImpl.countNums(input), TransformedImpl.tallyPositiveDigitSums(input));
    }
}