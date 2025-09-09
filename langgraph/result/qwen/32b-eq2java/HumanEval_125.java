import java.util.ArrayList;
import java.util.List;

public class HumanEval_125 {

    public List<String> extract_and_count_words(String input_text) {
        if (input_text.contains(" ")) {
            return List.of(input_text.split("\\s+"));
        } else if (input_text.contains(",")) {
            String cleanedText = input_text.replace(',', ' ');
            return List.of(cleanedText.split("\\s+"));
        } else {
            int count = 0;
            for (char c : input_text.toCharArray()) {
                if (Character.isLowerCase(c) && ((int) c) % 2 == 0) {
                    count++;
                }
            }
            return List.of(String.valueOf(count));
        }
    }
}