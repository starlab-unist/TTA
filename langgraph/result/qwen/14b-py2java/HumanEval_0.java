import java.util.List;

public class HumanEval_0 {
    public static boolean hasCloseElements(List<Double> numbers, double threshold) {
        for (int idx = 0; idx < numbers.size(); idx++) {
            double elem = numbers.get(idx);
            for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                if (idx != idx2) {
                    double elem2 = numbers.get(idx2);
                    double distance = Math.abs(elem - elem2);
                    if (distance < threshold) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}