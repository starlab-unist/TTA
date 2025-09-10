import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public static List<String> wordsString(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sList = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (letter == ',') {
                sList.append(' ');
            } else {
                sList.append(letter);
            }
        }

        return List.of(sList.toString().split("\\s+"));
    }
}