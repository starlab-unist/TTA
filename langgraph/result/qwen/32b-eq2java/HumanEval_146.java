import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class HumanEval_146 {

    public static int countSpecialNumbers(List<Integer> numbers) {
        
        int total = 0;
        Iterator<Integer> iterator = numbers.iterator();
        
        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (currentNumber > 10) {
                Set<Integer> oddDigitsSet = Set.of(1, 3, 5, 7, 9);
                String numStr = Integer.toString(currentNumber);
                if (oddDigitsSet.contains(Character.getNumericValue(numStr.charAt(0))) 
                        && oddDigitsSet.contains(Character.getNumericValue(numStr.charAt(numStr.length() - 1)))) {
                    total += 1;
                }
            }
        }
        
        return total;
    }
}