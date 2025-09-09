import java.util.List;

public class HumanEval_151 {
    public static int doubleTheDifference(List<Integer> lst) {
        return lst.stream()
                    .filter(i -> i > 0 && i % 2 != 0 && !str(i).contains("."))
                    .mapToInt(i -> i * i)
                    .sum();
    }

    private static String str(int i) {
        return Integer.toString(i);
    }
}