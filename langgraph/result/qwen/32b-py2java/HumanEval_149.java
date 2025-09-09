import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HumanEval_149 {
    public static List<String> sortedListSum(List<String> lst) {
        Collections.sort(lst);
        List<String> newLst = new ArrayList<>();
        for (String i : lst) {
            if (i.length() % 2 == 0) {
                newLst.add(i);
            }
        }
        Collections.sort(newLst, Comparator.comparingInt(String::length));
        return newLst;
    }
}