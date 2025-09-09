import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HumanEval_34 {
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> set = new TreeSet<>(l);
        return new ArrayList<>(set);
    }
}