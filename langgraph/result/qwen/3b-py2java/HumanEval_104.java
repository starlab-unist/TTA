import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_104 {

    public static ArrayList<Integer> uniqueDigits(int x) {
        ArrayList<Integer> oddDigitElements = new ArrayList<>();
        String numberStr = Integer.toString(x);
        for (char digitChar : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (digit % 2 != 0) {
                oddDigitElements.add(digit);
            }
        }
        Collections.sort(oddDigitElements);
        return oddDigitElements;
    }

}