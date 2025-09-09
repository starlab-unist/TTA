import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanEval_149 {

    public static ArrayList<String> sortedListSum(ArrayList<String> lst) {
        Collections.sort(lst);
        ArrayList<String> new_lst = new ArrayList<>();
        for (String element : lst) {
            if (element.length() % 2 == 0) {
                new_lst.add(element);
            }
        }
        Collections.sort(new_lst, Comparator.comparingInt(String::length));
        return new_lst;
    }
}