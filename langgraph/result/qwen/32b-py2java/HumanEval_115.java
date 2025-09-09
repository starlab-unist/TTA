import java.util.List;

public class HumanEval_115 {
    public int maxFill(List<List<Integer>> grid, double capacity) {
        int total = 0;
        for (List<Integer> arr : grid) {
            total += Math.ceil(arr.stream().mapToInt(Integer::intValue).sum() / capacity);
        }
        return total;
    }
}