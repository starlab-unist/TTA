import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public static List<String> processText(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new ArrayList<>();
        }

        List<Character> processedChars = new ArrayList<>();

        int index = 0;
        while (index < inputString.length()) {
            char ch = inputString.charAt(index);
            if (ch == ',') {
                processedChars.add(' ');
            } else {
                processedChars.add(ch);
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : processedChars) {
            sb.append(ch);
        }

        String processedString = sb.toString();
        return List.of(processedString.split("\\s+"));
    }
}