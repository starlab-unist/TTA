import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_145 {

    // Source Code
    static class HumanEval_145_Source {
        public static List<Integer> order_by_points(List<Integer> nums) {
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
            String numStr = Integer.toString(n);
            int sum = 0;
            for (char c : numStr.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            return sum * neg;
        }
    }

    // Transformed Code
    static class HumanEval_145_Transformed {

        public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
            Comparator<Integer> comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer number, Integer other) {
                    return Integer.compare(calculateWeight(number), calculateWeight(other));
                }
            };

            return numbers.stream().sorted(comparator).collect(Collectors.toList());
        }

        private static int calculateWeight(int number) {
            int sign = number < 0 ? -1 : 1;
            int absoluteValue = Math.abs(number);
            String digitsStr = Integer.toString(absoluteValue);
            int[] digits = new int[digitsStr.length()];
            
            for (int i = 0; i < digitsStr.length(); i++) {
                digits[i] = Character.getNumericValue(digitsStr.charAt(i));
            }
            
            digits[0] *= sign;
            return Arrays.stream(digits).sum();
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(123, 321, 213), List.of(123, 213, 321)},
        {List.of(-12, -21, 12, 21), List.of(-12, 12, -21, 21)},
        {List.of(0, 5, 10, 15), List.of(0, 5, 10, 15)},
        {List.of(987, 879, 798), List.of(798, 879, 987)},
        {List.of(-1234, -4321, 1234, 4321), List.of(-1234, 1234, -4321, 4321)},
        {List.of(555, 666, 777), List.of(555, 666, 777)},
        {List.of(-9, -8, -7, -6), List.of(-6, -7, -8, -9)},
        {List.of(100, 200, 300), List.of(100, 200, 300)},
        {List.of(5, -5, 10, -10), List.of(5, -5, 10, -10)},
        {List.of(111, -111, 222, -222), List.of(111, -111, 222, -222)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[0][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[1][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[2][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[3][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[4][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[5][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[6][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[7][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[8][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_145_Source.order_by_points((List<Integer>) testCases[9][0]), 
                     HumanEval_145_Transformed.sortNumbersByDigitSum((List<Integer>) testCases[9][0]));
    }
}