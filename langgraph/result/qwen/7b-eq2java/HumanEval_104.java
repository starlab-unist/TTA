import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanEval_104 {
    public List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
        List<Integer> oddDigitNumbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            boolean hasOnlyOddDigits = true;
            for (char digit : String.valueOf(number).toCharArray()) {
                if ((digit - '0') % 2 == 0) {
                    hasOnlyOddDigits = false;
                    break;
                }
            }
            if (hasOnlyOddDigits) {
                oddDigitNumbers.add(number);
            }
        }
        
        oddDigitNumbers.sort(null);
        return oddDigitNumbers;
    }
}