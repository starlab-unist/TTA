import java.util.*;

public class HumanEval_19 {
    public static String arrangeNumerals(String numberString) {
        Map<String, Integer> numeralToDigit = new HashMap<>();
        numeralToDigit.put("zero", 0);
        numeralToDigit.put("one", 1);
        numeralToDigit.put("two", 2);
        numeralToDigit.put("three", 3);
        numeralToDigit.put("four", 4);
        numeralToDigit.put("five", 5);
        numeralToDigit.put("six", 6);
        numeralToDigit.put("seven", 7);
        numeralToDigit.put("eight", 8);
        numeralToDigit.put("nine", 9);

        // Split the input string and filter out any empty strings
        String[] numeralArray = numberString.split(" ");
        List<String> numeralList = Arrays.asList(numeralArray).stream()
                .filter(numeral -> !numeral.isEmpty())
                .collect(Collectors.toList());

        // Sort the list based on the mapped digit values
        Collections.sort(numeralList, Comparator.comparingInt(n -> numeralToDigit.get(n)));

        // Join the sorted numerals back into a single string
        return String.join(" ", numeralList);
    }
}