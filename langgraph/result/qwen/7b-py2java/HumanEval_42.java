import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_42 {
    public static List<Integer> incrList(List<Integer> l) {
        return l.stream().map(e -> e + 1).collect(Collectors.toList());
    }
}