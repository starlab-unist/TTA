import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_149 {

    public static List<Integer> sortedListSum(List<String> lst) {
        List<Integer> newLst = new ArrayList<>();

        for (String s : lst) {
            if (s.length() % 2 == 0) {
                newLst.add(Integer.parseInt(s));
            }
        }

        Collections.sort(newLst);
        return newLst;
    }
}