import java.util.Comparator;
import java.util.List;

public class HumanEval_145 {

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