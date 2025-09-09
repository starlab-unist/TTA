import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_70 {
    public static ArrayList<Integer> strangeSortList(ArrayList<Integer> lst) {
        ArrayList<Integer> res = new ArrayList<>();
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