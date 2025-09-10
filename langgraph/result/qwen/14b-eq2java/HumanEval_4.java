import java.util.List;

public class HumanEval_4 {
    public static double calculateMeanAbsDev(List<Double> values) {
        double average = values.stream().mapToDouble(Double::doubleValue).sum() / values.size();
        double deviationSum = values.stream().mapToDouble(value -> Math.abs(value - average)).sum();
        return deviationSum / values.size();
    }
}