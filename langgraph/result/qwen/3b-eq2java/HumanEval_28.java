import java.util.List;

public class HumanEval_28 {

    public static String mergeStrings(List<String> stringList) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < stringList.size()) {
            result.append(stringList.get(index));
            index++;
        }
        return result.toString();
    }
}