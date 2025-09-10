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

        StringBuilder processedStringBuilder = new StringBuilder();
        for (char c : processedChars) {
            processedStringBuilder.append(c);
        }

        String processedString = processedStringBuilder.toString();
        return List.of(processedString.split("\\s+"));
    }
}