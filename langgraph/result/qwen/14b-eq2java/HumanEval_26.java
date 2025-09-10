import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HumanEval_26 {
    public static List<Integer> filterUniqueElements(List<Integer> numList) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : numList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int num : numList) {
            if (countMap.get(num) == 1) {
                uniqueNumbers.add(num);
            }
        }
        
        return uniqueNumbers;
    }
}