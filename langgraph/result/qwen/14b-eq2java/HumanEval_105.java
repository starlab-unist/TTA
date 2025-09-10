import java.util.*;

public class HumanEval_105 {
    public static List<String> arrangeByNumberName(int[] numbers) {
        Map<Integer, String> numberNames = new HashMap<>();
        numberNames.put(1, "One");
        numberNames.put(2, "Two");
        numberNames.put(3, "Three");
        numberNames.put(4, "Four");
        numberNames.put(5, "Five");
        numberNames.put(6, "Six");
        numberNames.put(7, "Seven");
        numberNames.put(8, "Eight");
        numberNames.put(9, "Nine");

        List<Integer> descendingNumbers = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();

        List<String> namedNumbers = new ArrayList<>();
        int index = 0;
        while (index < descendingNumbers.size()) {
            int num = descendingNumbers.get(index);
            if (numberNames.containsKey(num)) {
                namedNumbers.add(numberNames.get(num));
            }
            index++;
        }
        return namedNumbers;
    }
}