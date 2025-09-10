import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {
    public static Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (list1.length - list1.toString().replace(i, "").length() > t && !i.equals("")) {
                t = list1.length - list1.toString().replace(i, "").length();
            }
        }
        if (t > 0) {
            for (String i : list1) {
                if (list1.length - list1.toString().replace(i, "").length() == t) {
                    dict1.put(i, t);
                }
            }
        }
        return dict1;
    }
}