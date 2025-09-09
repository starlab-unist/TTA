import java.util.ArrayList;
import java.util.List;

public class HumanEval_125 {
    public static List<String> splitWords(String txt) {
        if (txt.contains(" ")) {
            return List.of(txt.split("\\s+"));
        } else if (txt.contains(",")) {
            return List.of(txt.replace(',', ' ').split("\\s+"));
        } else {
            int count = 0;
            for (char c : txt.toCharArray()) {
                if (Character.isLowerCase(c) && c % 2 == 0) {
                    count++;
                }
            }
            return List.of(String.valueOf(count));
        }
    }
}