import java.util.List;

public class HumanEval_4 {

    public static double calculateMeanAbsoluteDev(List<Double> values) {
        double average = 0.0;
        double deviationSum = 0.0;
        int counts = values.size();

        for (double value : values) {
            average += value;
        }
        average /= counts;

        for (double value : values) {
            deviationSum += Math.abs(value - average);
        }

        return deviationSum / counts;
    }
}