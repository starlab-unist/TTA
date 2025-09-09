import java.util.ArrayList;
import java.util.List;

class HumanEval_67 {
    public int fruitDistribution(String s, int n) {
        List<Integer> lis = new ArrayList<>();
        for (String i : s.split(" ")) {
            if (i.matches("\\d+")) {
                lis.add(Integer.parseInt(i));
            }
        }
        return n - lis.stream().mapToInt(Integer::intValue).sum();
    }
}