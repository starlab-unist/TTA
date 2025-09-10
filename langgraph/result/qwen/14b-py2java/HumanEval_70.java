import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_70 {
    public static List<Integer> strangeSortList(List<Integer> lst) {
        List<Integer> res = new ArrayList<>();
        boolean switchFlag = true;
        while (!lst.isEmpty()) {
            int value = switchFlag ? Collections.min(lst) : Collections.max(lst);
            res.add(value);
            lst.remove(Integer.valueOf(value));
            switchFlag = !switchFlag;
        }
        return res;
    }
}