import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public List<String> processText(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new ArrayList<>();
        }

        List<Character> processedChars = new ArrayList<>();

        int index = 0;
        while (index < inputString.length()) {
            char charAt = inputString.charAt(index);
            if (charAt == ',') {
                processedChars.add(' ');
            } else {
                processedChars.add(charAt);
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