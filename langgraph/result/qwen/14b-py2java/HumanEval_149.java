import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_149 {
    public static List<String> sortedListSum(List<String> lst) {
        Collections.sort(lst);
        List<String> newLst = new ArrayList<>();
        for (String i : lst) {
            if (i.length() % 2 == 0) {
                newLst.add(i);
            }
        }
        Collections.sort(newLst, (a, b) -> Integer.compare(a.length(), b.length()));
        return newLst;
    }
}