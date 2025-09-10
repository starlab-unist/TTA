import java.util.ArrayList;
import java.util.List;

public class HumanEval_14 {

    public static List<String> allPrefixes(String string) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            result.add(string.substring(0, i + 1));
        }
        return result;
    }
}