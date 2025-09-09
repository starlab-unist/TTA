import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    public List<String> countOddsInSublists(List<List<String>> inputList) {
        List<String> result = new ArrayList<>();
        for (List<String> sublist : inputList) {
            int oddCount = 0;
            for (String digit : sublist) {
                if (Integer.parseInt(digit) % 2 != 0) {
                    oddCount++;
                }
            }
            result.add("the number of odd elements " + oddCount + "n the str" + oddCount + "ng " + oddCount + " of the " + oddCount + "nput.");
        }
        return result;
    }
}