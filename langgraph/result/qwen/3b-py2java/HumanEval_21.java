import java.util.List;

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

        return numbers.stream()
                      .map(x -> (x - minNumber) / (maxNumber - minNumber))
                      .toList();
    }
}