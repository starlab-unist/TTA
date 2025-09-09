import java.util.List;

public class HumanEval_115 {
    public static int maxFill(List<List<Integer>> grid, int capacity) {
        int total = 0;
        for (List<Integer> row : grid) {
            double sum = row.stream().mapToInt(Integer::intValue).sum();
            total += Math.ceil(sum / capacity);
        }
        return total;
    }
}