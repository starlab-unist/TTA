import java.util.List;

public class HumanEval_29 {

    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .toList();
    }
}