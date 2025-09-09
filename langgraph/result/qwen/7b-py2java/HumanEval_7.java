import java.util.ArrayList;
import java.util.List;

public class HumanEval_7 {
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        List<String> filteredList = new ArrayList<>();
        for (String x : strings) {
            if (x.contains(substring)) {
                filteredList.add(x);
            }
        }
        return filteredList;
    }
}