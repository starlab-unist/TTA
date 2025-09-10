import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_21 {
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        double minNumber = Collections.min(numbers);
        double maxNumber = Collections.max(numbers);
        List<Double> rescaledNumbers = new ArrayList<>();
        for (double x : numbers) {
            rescaledNumbers.add((x - minNumber) / (maxNumber - minNumber));
        }
        return rescaledNumbers;
    }
}