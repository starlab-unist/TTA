import java.util.List;

public class HumanEval_28 {
    public static String concatenate(List<String> strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
}