import java.util.List;

public class HumanEval_0 {
    public static boolean hasCloseElements(List<Double> numbers, double threshold) {
        for (int idx = 0; idx < numbers.size(); idx++) {
            for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                if (idx != idx2) {
                    double distance = Math.abs(numbers.get(idx) - numbers.get(idx2));
                    if (distance < threshold) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}