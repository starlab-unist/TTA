import java.util.List;

public class HumanEval_142 {
    public static int sumSquares(List<Integer> lst) {
        int sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            int value;
            if (i % 3 == 0) {
                value = lst.get(i) * lst.get(i);
            } else if (i % 4 == 0) {
                value = lst.get(i) * lst.get(i) * lst.get(i);
            } else {
                value = lst.get(i);
            }
            sum += value;
        }
        return sum;
    }
}