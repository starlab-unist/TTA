import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {
    public static Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (list1.length > 0 && list1[0].equals(i)) {
                continue;
            }
            int count = 0;
            for (String j : list1) {
                if (i.equals(j)) {
                    count++;
                }
            }
            if (count > t && !i.isEmpty()) {
                t = count;
            }
        }

        if (t > 0) {
            for (String i : list1) {
                if (i.equals("") || dict1.containsKey(i)) {
                    continue;
                }
                int count = 0;
                for (String j : list1) {
                    if (i.equals(j)) {
                        count++;
                    }
                }
                if (count == t) {
                    dict1.put(i, t);
                }
            }
        }

        return dict1;
    }
}