import java.util.*;

public class HumanEval_105 {
    public List<String> byLength(List<Integer> arr) {
        Map<Integer, String> dic = new HashMap<>();
        dic.put(1, "One");
        dic.put(2, "Two");
        dic.put(3, "Three");
        dic.put(4, "Four");
        dic.put(5, "Five");
        dic.put(6, "Six");
        dic.put(7, "Seven");
        dic.put(8, "Eight");
        dic.put(9, "Nine");

        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr, Collections.reverseOrder());

        List<String> new_arr = new ArrayList<>();
        int index = 0;
        while (index < sortedArr.size()) {
            int num = sortedArr.get(index);
            if (dic.containsKey(num)) {
                new_arr.add(dic.get(num));
            }
            index++;
        }
        return new_arr;
    }
}