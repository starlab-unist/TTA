import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class HumanEval_146 {

    public static int countSpecialNumbers(int[] numbers) {
        
        int total = 0;
        Iterator<Integer> iterator = new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < numbers.length;
            }
            @Override
            public Integer next() {
                return numbers[index++];
            }
        };
        
        while (true) {
            try {
                int currentNumber = iterator.next();
                if (currentNumber > 10) {
                    Set<Integer> oddDigitsSet = new HashSet<>();
                    oddDigitsSet.add(1);
                    oddDigitsSet.add(3);
                    oddDigitsSet.add(5);
                    oddDigitsSet.add(7);
                    oddDigitsSet.add(9);
                    String numStr = String.valueOf(currentNumber);
                    if (oddDigitsSet.contains(Integer.parseInt(String.valueOf(numStr.charAt(0)))) && 
                        oddDigitsSet.contains(Integer.parseInt(String.valueOf(numStr.charAt(numStr.length() - 1))))) {
                        total++;
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        
        return total;
    }
}