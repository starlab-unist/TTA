import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HumanEval_146 {

    public static int countSpecialNumbers(int[] nums) {
        int count = 0;
        Iterator<Integer> iterator = new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < nums.length;
            }

            @Override
            public Integer next() {
                return nums[index++];
            }
        };

        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (currentNumber > 10) {
                Set<Integer> oddDigitsSet = new HashSet<>();
                oddDigitsSet.add(1);
                oddDigitsSet.add(3);
                oddDigitsSet.add(5);
                oddDigitsSet.add(7);
                oddDigitsSet.add(9);
                String numStr = String.valueOf(currentNumber);
                int firstDigit = Character.getNumericValue(numStr.charAt(0));
                int lastDigit = Character.getNumericValue(numStr.charAt(numStr.length() - 1));
                if (oddDigitsSet.contains(firstDigit) && oddDigitsSet.contains(lastDigit)) {
                    count++;
                }
            }
        }

        return count;
    }
}