import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_26 {
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer number : numbers) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (countMap.get(number) <= 1) {
                result.add(number);
            }
        }
        return result;
    }
}