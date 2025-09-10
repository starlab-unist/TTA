import java.util.ArrayList;
import java.util.List;

public class HumanEval_104 {
    public static List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
        List<Integer> oddDigitNumbers = new ArrayList<>();
        
        for (int number : numbers) {
            String numStr = Integer.toString(number);
            boolean hasOddDigit = true;
            
            for (char c : numStr.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit % 2 == 0) {
                    hasOddDigit = false;
                    break;
                }
            }
            
            if (hasOddDigit) {
                oddDigitNumbers.add(number);
            }
        }
        
        oddDigitNumbers.sort(Integer::compareTo);
        return oddDigitNumbers;
    }
}