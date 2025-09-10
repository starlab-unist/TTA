import java.util.List;

public class HumanEval_8 {

    public static int[] calculateAggregates(List<Integer> values) {
        int totalSum = 0;
        int cumulativeProduct = 1;

        int index = 0;
        while (index < values.size()) {
            totalSum += values.get(index);
            cumulativeProduct *= values.get(index);
            index++;
        }

        return new int[]{totalSum, cumulativeProduct};
    }
}