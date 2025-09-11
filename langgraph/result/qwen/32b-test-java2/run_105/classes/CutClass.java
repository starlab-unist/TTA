import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HumanEval_105 {

    public List<String> arrangeByNumberName(List<Integer> numbers) {
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

        List<Integer> descendingNumbers = new ArrayList<>(numbers);
        Collections.sort(descendingNumbers, Comparator.reverseOrder());

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