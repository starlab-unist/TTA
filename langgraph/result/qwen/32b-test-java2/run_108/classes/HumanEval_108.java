import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_108 {

    // Source Code
    static class HumanEval_108_Source {
        public int countNums(List<Integer> arr) {
            return (int) arr.stream()
                    .mapToInt(this::digitsSum)
                    .filter(x -> x > 0)
                    .count();
        }

        private int digitsSum(int n) {
            int neg = 1;
            if (n < 0) {
                n = -1 * n;
                neg = -1;
            }
            String[] digits = String.valueOf(n).split("");
            int sum = 0;
            for (int i = 0; i < digits.length; i++) {
                sum += Integer.parseInt(digits[i]);
            }
            sum *= neg;
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_108_Transformed {
        public int tallyPositiveDigitSums(int[] numbers) {
            int positiveSumsCount = 0;
            for (int num : numbers) {
                if (computeDigitSum(num) > 0) {
                    positiveSumsCount++;
                }
            }
            return positiveSumsCount;
        }

        private int computeDigitSum(int number) {
            int sign = number < 0 ? -1 : 1;
            int absoluteValue = Math.abs(number);
            String numberStr = Integer.toString(absoluteValue);
            int[] digitList = new int[numberStr.length()];

            for (int i = 0; i < numberStr.length(); i++) {
                digitList[i] = Character.getNumericValue(numberStr.charAt(i));
            }
            digitList[0] *= sign;

            int sum = 0;
            for (int digit : digitList) {
                sum += digit;
            }
            return sum;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {123, -456, 789}, 
        {-111, 222, -333, 444},
        {0, 0, 0},
        {-1, 1, -1, 1},
        {999, -888, 777, -666},
        {1001, 2002, -3003, 4004},
        {-5, 5, -5, 5, -5},
        {10, -20, 30, -40, 50},
        {987654321, -123456789},
        {-12345, 12345, -12345}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void countNums_vs_tallyPositiveDigitSums(Integer[] inputNumbers) {
        HumanEval_108_Source source = new HumanEval_108_Source();
        HumanEval_108_Transformed transformed = new HumanEval_108_Transformed();

        assertEquals(
            source.countNums(List.of(inputNumbers)),
            transformed.tallyPositiveDigitSums(Arrays.stream(inputNumbers).mapToInt(i -> i).toArray())
        );
    }
}