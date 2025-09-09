import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_34 {
    public static List<Integer> unique(List<Integer> l) {
        return l.stream().distinct().sorted().collect(Collectors.toList());
    }
}