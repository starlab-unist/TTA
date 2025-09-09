import java.util.List;

public class HumanEval_7 {

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(x -> x.contains(substring))
                .collect(Collectors.toList());
    }
}