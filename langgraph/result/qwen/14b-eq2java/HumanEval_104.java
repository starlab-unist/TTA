import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanEval_104 {
    public static List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
        List<Integer> oddDigitNumbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            boolean allOddDigits = true;
            for (char digit : String.valueOf(number).toCharArray()) {
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