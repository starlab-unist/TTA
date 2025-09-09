import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HumanEval_145 {
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