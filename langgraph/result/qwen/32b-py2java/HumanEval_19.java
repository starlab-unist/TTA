import java.util.*;

public class HumanEval_19 {
    public static String sortNumbers(String numbers) {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("zero", 0);
        valueMap.put("one", 1);
        valueMap.put("two", 2);
        valueMap.put("three", 3);
        valueMap.put("four", 4);
        valueMap.put("five", 5);
        valueMap.put("six", 6);
        valueMap.put("seven", 7);
        valueMap.put("eight", 8);
        valueMap.put("nine", 9);

        String[] numberArray = numbers.split(" ");
        List<String> filteredList = new ArrayList<>();
        for (String num : numberArray) {
            if (!num.isEmpty()) {
                filteredList.add(num);
            }
        }

        Collections.sort(filteredList, Comparator.comparingInt(valueMap::get));

        return String.join(" ", filteredList);
    }
}