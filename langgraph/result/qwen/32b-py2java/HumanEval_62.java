import java.util.ArrayList;
import java.util.List;

public class HumanEval_62 {
    public List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < xs.size(); i++) {
            result.add(i * xs.get(i));
        }
        return result;
    }
}