import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
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
    private static final Object[][] testCases = {
        {Arrays.asList(123, -456, 789), new int[]{123, -456, 789}},
        {Arrays.asList(-111, 222, -333, 444), new int[]{-111, 222, -333, 444}},
        {Arrays.asList(0, 0, 0), new int[]{0, 0, 0}},
        {Arrays.asList(-1, 1, -1, 1), new int[]{-1, 1, -1, 1}},
        {Arrays.asList(999, -888, 777, -666), new int[]{999, -888, 777, -666}},
        {Arrays.asList(1001, 2002, -3003, 4004), new int[]{1001, 2002, -3003, 4004}},
        {Arrays.asList(-5, 5, -5, 5, -5), new int[]{-5, 5, -5, 5, -5}},
        {Arrays.asList(10, -20, 30, -40, 50), new int[]{10, -20, 30, -40, 50}},
        {Arrays.asList(987654321, -123456789), new int[]{987654321, -123456789}},
        {Arrays.asList(-12345, 12345, -12345), new int[]{-12345, 12345, -12345}}
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[0][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[1][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[2][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[3][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[4][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[5][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[6][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[7][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[8][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_108_Source().countNums((List<Integer>) testCases[9][0]), 
                     new HumanEval_108_Transformed().tallyPositiveDigitSums((int[]) testCases[9][1]));
    }
}