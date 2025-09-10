import java.util.*;

public class HumanEval_105 {
    public static List<String> byLength(int[] arr) {
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

        Arrays.sort(arr);
        List<String> newArr = new ArrayList<>();
        for (int var : arr) {
            if (dic.containsKey(var)) {
                newArr.add(dic.get(var));
            }
        }
        Collections.reverse(newArr);
        return newArr;
    }
}