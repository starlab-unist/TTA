import java.util.List;

public class human_eval_0 {

    public static boolean hasCloseElements(List<Double> numbers, double threshold) {
        for (int i = 0; i < numbers.size(); i++) {
            double elem = numbers.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {
                    double elem2 = numbers.get(j);
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
