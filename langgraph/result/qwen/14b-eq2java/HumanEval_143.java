import java.util.ArrayList;
import java.util.List;

public class HumanEval_143 {
    public static String filterUniqueLengthWords(String phrase) {
        List<String> result = new ArrayList<>();
        String[] terms = phrase.split("\\s+");
        
        for (String term : terms) {
            boolean flag = false;
            if (term.length() == 1) {
                flag = true;
            }
            int divisor = 2;
            while (divisor < term.length()) {
                if (term.length() % divisor == 0) {
                    flag = true;
                    break;
                }
                divisor++;
            }
            if (!flag || term.length() == 2) {
                result.add(term);
            }
        }
        return String.join(" ", result);
    }
}