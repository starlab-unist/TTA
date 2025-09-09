import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanEval_104 {
    public List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
        List<Integer> oddDigitNumbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        
        while (iterator.hasNext()) {
            int number = iterator.next();
            String numberStr = Integer.toString(number);
            boolean allOddDigits = true;
            
            for (char digit : numberStr.toCharArray()) {
                if ((digit - '0') % 2 == 0) {
                    allOddDigits = false;
                    break;
                }
            }
            
            if (allOddDigits) {
                oddDigitNumbers.add(number);
            }
        }
        
        Collections.sort(oddDigitNumbers);
        return oddDigitNumbers;
    }
}