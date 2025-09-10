import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_104 {
    public static List<Integer> uniqueDigits(List<Integer> x) {
        List<Integer> oddDigitElements = new ArrayList<>();
        for (Integer i : x) {
            boolean allOdd = true;
            for (char c : String.valueOf(i).toCharArray()) {
                if ((c - '0') % 2 == 0) {
                    allOdd = false;
                    break;
                }
            }
            if (allOdd) {
                oddDigitElements.add(i);
            }
        }
        Collections.sort(oddDigitElements);
        return oddDigitElements;
    }
}