import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    public static List<String> countOddsInSublists(List<List<String>> inputList) {
        List<String> result = new ArrayList<>();
        for (List<String> sublist : inputList) {
            int oddCount = 0;
            for (String digit : sublist) {
                if (Integer.parseInt(digit) % 2 != 0) {
                    oddCount++;
                }
            }
            result.add(String.format("the number of odd elements %dn the str%dsng %d of the %dnput.", oddCount, oddCount, oddCount, oddCount));
        }
        return result;
    }
}