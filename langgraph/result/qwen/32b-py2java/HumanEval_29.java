import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class HumanEval_29 {
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                      .filter(x -> x.startsWith(prefix))
                      .collect(Collectors.toList());
    }
}