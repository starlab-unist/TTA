import java.util.List;

public class HumanEval_4 {
    public static double meanAbsoluteDeviation(List<Double> numbers) {
        double mean = numbers.stream().mapToDouble(Double::doubleValue).sum() / numbers.size();
        return numbers.stream().mapToDouble(num -> Math.abs(num - mean)).sum() / numbers.size();
    }
}