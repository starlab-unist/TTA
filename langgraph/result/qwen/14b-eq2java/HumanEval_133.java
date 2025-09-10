import java.util.Iterator;
import java.util.List;

public class HumanEval_133 {
    public static int calculateTotalSquaredCeilings(List<Double> numbers) {
        int total = 0;
        Iterator<Double> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            double number = iterator.next();
            total += Math.ceil(number) * Math.ceil(number);
        }
        return total;
    }
}