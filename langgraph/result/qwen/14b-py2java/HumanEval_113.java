import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    public static List<String> oddCount(List<List<Integer>> lst) {
        List<String> res = new ArrayList<>();
        for (List<Integer> arr : lst) {
            int n = 0;
            for (int d : arr) {
                if (d % 2 == 1) {
                    n++;
                }
            }
            res.add("the number of odd elements " + n + "n the str" + n + "ng " + n + " of the " + n + "nput.");
        }
        return res;
    }
}