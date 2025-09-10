import java.util.List;
import java.util.ArrayList;

public class HumanEval_142 {
    public static int sumSquares(List<Integer> lst) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            if (i % 3 == 0) {
                result.add(lst.get(i) * lst.get(i));
            } else if (i % 4 == 0 && i % 3 != 0) {
                result.add(lst.get(i) * lst.get(i) * lst.get(i));
            } else {
                result.add(lst.get(i));
            }
        }
        int sum = 0;
        for (int num : result) {
            sum += num;
        }
        return sum;
    }
}