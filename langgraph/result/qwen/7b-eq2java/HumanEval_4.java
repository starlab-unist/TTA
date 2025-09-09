import java.util.List;

public class HumanEval_4 {
    public static double calculateMeanAbsDev(List<Double> values) {
        double average = values.stream().mapToDouble(val -> val).average().orElse(0.0);
        double deviationSum = values.stream().mapToDouble(val -> Math.abs(val - average)).sum();
        return deviationSum / values.size();
    }
}