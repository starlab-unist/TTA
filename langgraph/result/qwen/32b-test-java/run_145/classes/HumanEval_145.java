import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_145 {

    // Source Code
    static class SourceCode {
        public static List<Integer> orderByPoints(List<Integer> nums) {
            return nums.stream()
                       .sorted(Comparator.comparingInt(SourceCode::digitsSum))
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
    static class TransformedCode {
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
    private static final List<List<Integer>> testCasesInputs = Arrays.asList(
        Arrays.asList(123, 321, 213),
        Arrays.asList(-12, -21, 12, 21),
        Arrays.asList(0, 5, 10, 15),
        Arrays.asList(987, 879, 798),
        Arrays.asList(-1234, -4321, 1234, 4321),
        Arrays.asList(555, 666, 777),
        Arrays.asList(-9, -8, -7, -6),
        Arrays.asList(100, 200, 300),
        Arrays.asList(5, -5, 10, -10),
        Arrays.asList(111, -111, 222, -222)
    );

    private static final List<List<Integer>> testCasesExpectedOutputs = Arrays.asList(
        Arrays.asList(123, 213, 321),
        Arrays.asList(-12, 12, -21, 21),
        Arrays.asList(0, 5, 10, 15),
        Arrays.asList(798, 879, 987),
        Arrays.asList(-1234, 1234, -4321, 4321),
        Arrays.asList(555, 666, 777),
        Arrays.asList(-6, -7, -8, -9),
        Arrays.asList(100, 200, 300),
        Arrays.asList(5, -5, 10, -10),
        Arrays.asList(111, -111, 222, -222)
    );

    @Test
    public void test_0() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(0)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(0))));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(1)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(1))));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(2)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(2))));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(3)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(3))));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(4)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(4))));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(5)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(5))));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(6)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(6))));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(7)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(7))));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(8)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(8))));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.orderByPoints(testCasesInputs.get(9)), TransformedCode.sortNumbersByDigitSum(new ArrayList<>(testCasesInputs.get(9))));
    }
}