import java.util.List;
import java.util.ArrayList;

public class HumanEval_21 {
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
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
        
        List<Double> scaledNumbers = new ArrayList<>();
        for (double number : numbers) {
            scaledNumbers.add((number - minNumber) / (maxNumber - minNumber));
        }
        
        return scaledNumbers;
    }
}