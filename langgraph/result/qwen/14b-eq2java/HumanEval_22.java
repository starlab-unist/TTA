import java.util.ArrayList;
import java.util.List;

public class HumanEval_22 {
    public static List<Integer> extractIntegers(List<Object> data) {
        List<Integer> result = new ArrayList<>();
        for (Object item : data) {
            if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }
}