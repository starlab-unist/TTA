import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public static List<String> wordsString(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> sList = new ArrayList<>();

        for (char letter : s.toCharArray()) {
            if (letter == ',') {
                sList.add(" ");
            } else {
                sList.add(String.valueOf(letter));
            }
        }

        String result = String.join("", sList);
        return List.of(result.split("\\s+"));
    }
}