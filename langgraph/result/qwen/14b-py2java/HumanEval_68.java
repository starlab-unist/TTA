import java.util.ArrayList;
import java.util.List;

public class HumanEval_68 {
    public static List<Object> pluck(List<Integer> arr) {
        if (arr.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Integer> evens = new ArrayList<>();
        for (Integer x : arr) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        
        if (evens.isEmpty()) {
            return new ArrayList<>();
        }
        
        int minEven = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0 && arr.get(i) < minEven) {
                minEven = arr.get(i);
                minIndex = i;
            }
        }
        
        List<Object> result = new ArrayList<>();
        result.add(minEven);
        result.add(minIndex);
        return result;
    }
}