import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_37 {
    public static List<Integer> sortEven(List<Integer> l) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            if (i % 2 == 0) {
                evens.add(l.get(i));
            } else {
                odds.add(l.get(i));
            }
        }

        Collections.sort(evens);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(evens.size(), odds.size()); i++) {
            ans.add(evens.get(i));
            ans.add(odds.get(i));
        }

        if (evens.size() > odds.size()) {
            ans.add(evens.get(evens.size() - 1));
        }

        return ans;
    }
}