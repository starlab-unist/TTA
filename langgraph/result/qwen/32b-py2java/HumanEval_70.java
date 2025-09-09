import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HumanEval_70 {
    public static List<Integer> strangeSortList(List<Integer> lst) {
        List<Integer> res = new ArrayList<>();
        boolean switcher = true;
        while (!lst.isEmpty()) {
            int value = switcher ? Collections.min(lst) : Collections.max(lst);
            res.add(value);
            lst.remove(Integer.valueOf(value));
            switcher = !switcher;
        }
        return res;
    }
}