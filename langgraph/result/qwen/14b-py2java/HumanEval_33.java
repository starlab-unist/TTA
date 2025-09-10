import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_33 {
    public static List<Integer> sortThird(List<Integer> l) {
        List<Integer> result = new ArrayList<>(l);
        List<Integer> thirdElements = new ArrayList<>();
        
        for (int i = 0; i < result.size(); i += 3) {
            thirdElements.add(result.get(i));
        }
        
        Collections.sort(thirdElements);
        
        for (int i = 0, j = 0; i < result.size(); i += 3, j++) {
            result.set(i, thirdElements.get(j));
        }
        
        return result;
    }
}