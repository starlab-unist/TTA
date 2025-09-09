import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public List<String> wordsString(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sBuilder = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (letter == ',') {
                sBuilder.append(' ');
            } else {
                sBuilder.append(letter);
            }
        }

        String result = sBuilder.toString();
        return List.of(result.split("\\s+"));
    }
}