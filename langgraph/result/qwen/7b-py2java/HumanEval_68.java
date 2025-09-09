import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanEval_68 {

    public static List<Integer> pluck(List<Integer> arr) {
        if (arr.isEmpty()) return new ArrayList<>();
        
        List<Integer> evens = new ArrayList<>();
        for (int x : arr) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        
        if (evens.isEmpty()) return new ArrayList<>();
        
        int minEven = Collections.min(evens);
        int index = arr.indexOf(minEven);
        
        return Arrays.asList(minEven, index);
    }
}