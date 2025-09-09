import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_33 {
    public static ArrayList<Integer> sortThird(ArrayList<Integer> l) {
        ArrayList<Integer> elementsToSort = new ArrayList<>();
        for (int i = 0; i < l.size(); i += 3) {
            elementsToSort.add(l.get(i));
        }
        Collections.sort(elementsToSort);
        ArrayList<Integer> resultList = new ArrayList<>(l);
        for (int i = 0, j = 0; i < resultList.size(); i += 3, ++j) {
            resultList.set(i, elementsToSort.get(j));
        }
        return resultList;
    }
}