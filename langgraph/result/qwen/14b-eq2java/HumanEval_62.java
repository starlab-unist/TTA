import java.util.ArrayList;
import java.util.List;

public class HumanEval_62 {
    public static List<Integer> computeDerivative(List<Integer> coefficients) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index < coefficients.size()) {
            result.add(index * coefficients.get(index));
            index += 1;
        }
        return result;
    }
}