import java.util.List;
import java.util.ArrayList;

public class HumanEval_21 {

    public static List<Double> rescaleToUnit(List<Double> numbers) {
        double minNumber = Double.MAX_VALUE;
        double maxNumber = Double.MIN_VALUE;

        for (double number : numbers) {
            if (number < minNumber) {
                minNumber = number;
            }
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        List<Double> rescaledNumbers = new ArrayList<>();
        for (double x : numbers) {
            rescaledNumbers.add((x - minNumber) / (maxNumber - minNumber));
        }

        return rescaledNumbers;
    }
}