import java.util.List;
import java.util.Collections;

public class HumanEval_47 {
    public static double median(List<Double> l) {
        Collections.sort(l);
        int size = l.size();
        if (size % 2 == 1) {
            return l.get(size / 2);
        } else {
            return (l.get(size / 2 - 1) + l.get(size / 2)) / 2.0;
        }
    }
}