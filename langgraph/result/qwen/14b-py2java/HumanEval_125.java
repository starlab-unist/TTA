import java.util.List;
import java.util.Arrays;

public class HumanEval_125 {
    public static List<String> splitWords(String txt) {
        if (txt.contains(" ")) {
            return Arrays.asList(txt.split(" "));
        } else if (txt.contains(",")) {
            return Arrays.asList(txt.replace(',', ' ').split(" "));
        } else {
            long count = txt.chars()
                             .filter(c -> Character.isLowerCase(c) && c % 2 == 0)
                             .count();
            return Arrays.asList(Long.toString(count));
        }
    }
}