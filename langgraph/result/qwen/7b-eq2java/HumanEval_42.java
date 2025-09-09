import java.util.ArrayList;
import java.util.List;

public class HumanEval_42 {
    public static List<Integer> incrList(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < l.size()) {
            result.add(l.get(index) + 1);
            index++;
        }
        return result;
    }
}