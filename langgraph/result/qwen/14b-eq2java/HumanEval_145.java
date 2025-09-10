import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanEval_145 {
    public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparingInt(HumanEval_145::calculateWeight))
                .collect(Collectors.toList());
    }

    private static int calculateWeight(int number) {
        int sign = Integer.signum(number);
        int absoluteValue = Math.abs(number);
        List<Integer> digits = new ArrayList<>();
        
        while (absoluteValue > 0) {
            digits.add(absoluteValue % 10);
            absoluteValue /= 10;
        }
        
        if (!digits.isEmpty()) {
            digits.set(0, digits.get(0) * sign);
        }
        
        return digits.stream().mapToInt(Integer::intValue).sum();
    }
}