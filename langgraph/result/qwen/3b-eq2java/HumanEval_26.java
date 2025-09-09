import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class HumanEval_26 {

    public static List<Integer> filterUniqueElements(List<Integer> numList) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each number
        for (int num : numList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Collect numbers that appear exactly once
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int num : numList) {
            if (countMap.get(num) == 1) {
                uniqueNumbers.add(num);
            }
        }
        
        return uniqueNumbers;
    }

}