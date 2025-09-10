import java.util.List;
import java.util.Arrays;

public class HumanEval_125 {

    public static Object extract_and_count_words(String input_text) {
        if (input_text.contains(" ")) {
            List<String> word_list = Arrays.asList(input_text.split(" "));
            return word_list;
        } else if (input_text.contains(",")) {
            List<String> word_list = Arrays.asList(input_text.replace(",", " ").split(" "));
            return word_list;
        } else {
            int count = 0;
            for (char c : input_text.toCharArray()) {
                if (Character.isLowerCase(c) && (int) c % 2 == 0) {
                    count++;
                }
            }
            return count;
        }
    }
}