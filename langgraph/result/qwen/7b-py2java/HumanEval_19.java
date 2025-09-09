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

        List<String> sortedList = Arrays.stream(numbers.split(" "))
                .filter(x -> !x.isEmpty())
                .sorted(Comparator.comparingInt(valueMap::get))
                .collect(Collectors.toList());

        return String.join(" ", sortedList);
    }

}