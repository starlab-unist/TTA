import java.util.ArrayList;
import java.util.List;

public class HumanEval_68 {
    public static List<Integer> pluck(List<Integer> arr) {
        if (arr.isEmpty()) return new ArrayList<>();
        
        List<Integer> evens = new ArrayList<>();
        for (Integer x : arr) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        
        if (evens.isEmpty()) return new ArrayList<>();
        
        int minEven = Integer.MAX_VALUE;
        for (Integer even : evens) {
            if (even < minEven) {
                minEven = even;
            }
        }
        
        int index = arr.indexOf(minEven);
        List<Integer> result = new ArrayList<>();
        result.add(minEven);
        result.add(index);
        
        return result;
    }
}