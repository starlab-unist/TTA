import java.util.HashMap;
import java.util.Map;

class HumanEval_111 {
    public Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (!i.isEmpty() && countOccurrences(list1, i) > t) {
                t = countOccurrences(list1, i);
            }
        }
        if (t > 0) {
            for (String i : list1) {
                if (countOccurrences(list1, i) == t) {
                    dict1.put(i, t);
                }
            }
        }
        return dict1;
    }

    private int countOccurrences(String[] array, String value) {
        int count = 0;
        for (String element : array) {
            if (element.equals(value)) {
                count++;
            }
        }
        return count;
    }
}