import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HumanEval_34 {
    public static List<Integer> unique(List<Integer> l) {
        HashSet<Integer> set = new HashSet<>(l);
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}