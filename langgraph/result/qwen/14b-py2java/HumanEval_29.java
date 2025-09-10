import java.util.ArrayList;
import java.util.List;

public class HumanEval_29 {
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        List<String> result = new ArrayList<>();
        for (String x : strings) {
            if (x.startsWith(prefix)) {
                result.add(x);
            }
        }
        return result;
    }
}