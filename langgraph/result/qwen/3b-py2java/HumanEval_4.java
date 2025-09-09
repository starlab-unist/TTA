import java.util.List;

public class HumanEval_4 {

    public static double meanAbsoluteDeviation(List<Double> numbers) {
        double mean = 0.0;
        for (double number : numbers) {
            mean += number;
        }
        mean /= numbers.size();

        double sumOfAbsoluteDifferences = 0.0;
        for (double number : numbers) {
            sumOfAbsoluteDifferences += Math.abs(number - mean);
        }
        return sumOfAbsoluteDifferences / numbers.size();
    }

}