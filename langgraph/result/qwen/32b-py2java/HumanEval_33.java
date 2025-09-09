import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_33 {
    public static List<Integer> sortThird(List<Integer> l) {
        List<Integer> result = new ArrayList<>(l);
        List<Integer> everyThird = new ArrayList<>();
        
        for (int i = 0; i < result.size(); i += 3) {
            everyThird.add(result.get(i));
        }
        
        Collections.sort(everyThird);
        
        for (int i = 0, j = 0; i < result.size(); i += 3, j++) {
            result.set(i, everyThird.get(j));
        }
        
        return result;
    }
}