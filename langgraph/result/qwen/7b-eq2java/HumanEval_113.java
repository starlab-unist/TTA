import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    public List<String> countOddsInSublists(List<List<Integer>> inputList) {
        List<String> result = new ArrayList<>();
        for (List<Integer> sublist : inputList) {
            long oddCount = sublist.stream().filter(digit -> digit % 2 != 0).count();
            result.add("the number of odd elements " + oddCount + "n the str" + oddCount + "ng " + oddCount + " of the " + oddCount + "nput.");
        }
        return result;
    }
}