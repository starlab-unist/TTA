import java.util.List;

public class HumanEval_115 {
    public static int maxFill(List<List<Integer>> grid, double capacity) {
        int total = 0;
        for (List<Integer> arr : grid) {
            double sum = 0;
            for (int num : arr) {
                sum += num;
            }
            total += Math.ceil(sum / capacity);
        }
        return total;
    }
}