import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_70 {
    public static ArrayList<Integer> strangeSortList(ArrayList<Integer> lst) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean switchFlag = true;
        
        while (!lst.isEmpty()) {
            int selectedValue;
            if (switchFlag) {
                selectedValue = Collections.min(lst);
            } else {
                selectedValue = Collections.max(lst);
            }
            res.add(selectedValue);
            lst.remove(Integer.valueOf(selectedValue));
            switchFlag = !switchFlag;
        }
        
        return res;
    }
}