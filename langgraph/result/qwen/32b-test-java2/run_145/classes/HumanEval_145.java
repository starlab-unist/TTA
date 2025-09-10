import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_145 {

    // Source Code
    static class HumanEval_145_Source {
        public static List<Integer> orderByPoints(List<Integer> nums) {
            return nums.stream()
                       .sorted(Comparator.comparingInt(HumanEval_145_Source::digitsSum))
                       .collect(Collectors.toList());
        }

        private static int digitsSum(int n) {
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
    static class HumanEval_145_Transformed_Variant {
        public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
            Comparator<Integer> byDigitSum = new Comparator<Integer>() {
                @Override
                public int compare(Integer number1, Integer number2) {
                    return Integer.compare(calculateWeight(number1), calculateWeight(number2));
                }
            };

            Collections.sort(numbers, byDigitSum);
            return numbers;
        }

        private static int calculateWeight(int number) {
            int sign = number < 0 ? -1 : 1;
            int absoluteValue = Math.abs(number);
            String numberStr = Integer.toString(absoluteValue);
            int[] digits = new int[numberStr.length()];
            
            for (int i = 0; i < numberStr.length(); i++) {
                digits[i] = Character.getNumericValue(numberStr.charAt(i));
            }
            
            digits[0] *= sign;
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }
            
            return sum;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(123), Arrays.asList(123)},
        {Arrays.asList(-12), Arrays.asList(-12)},
        {Arrays.asList(0), Arrays.asList(0)},
        {Arrays.asList(987), Arrays.asList(987)},
        {Arrays.asList(-1234), Arrays.asList(-1234)},
        {Arrays.asList(555), Arrays.asList(555)},
        {Arrays.asList(-9), Arrays.asList(-9)},
        {Arrays.asList(100), Arrays.asList(100)},
        {Arrays.asList(5, -5), Arrays.asList(5, -5)},
        {Arrays.asList(111, -111), Arrays.asList(111, -111)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.of((List<Integer>) args[0], (List<Integer>) args[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of orderByPoints and sortNumbersByDigitSum")
    void testOrderByPoints_vs_sortNumbersByDigitSum(List<Integer> input, List<Integer> expected) {
        assertEquals(
            HumanEval_145_Source.orderByPoints(input),
            HumanEval_145_Transformed_Variant.sortNumbersByDigitSum(new ArrayList<>(input)) // Create a new list to avoid mutation
        );
    }
}