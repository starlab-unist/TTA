import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanEval_104 {
    public List<Integer> uniqueDigits(List<Integer> x) {
        List<Integer> oddDigitElements = new ArrayList<>();
        for (Integer i : x) {
            if (allOddDigits(i)) {
                oddDigitElements.add(i);
            }
        }
        oddDigitElements.sort(null);
        return oddDigitElements;
    }

    private boolean allOddDigits(Integer number) {
        String numStr = number.toString();
        for (char c : numStr.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}