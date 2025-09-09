import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    public List<String> oddCount(List<String> lst) {
        List<String> res = new ArrayList<>();
        for (String arr : lst) {
            int n = 0;
            for (char c : arr.toCharArray()) {
                if ((c - '0') % 2 == 1) {
                    n++;
                }
            }
            res.add("the number of odd elements " + n + "n the str" + n + "ng " + n + " of the " + n + "nput.");
        }
        return res;
    }
}