import java.util.ArrayList;
import java.util.Arrays;

public class HumanEval_143 {
    public static String wordsInSentence(String phrase) {
        ArrayList<String> newLst = new ArrayList<>();
        String[] terms = phrase.split(" ");
        for (String term : terms) {
            boolean flg = false;
            if (term.length() == 1) {
                flg = true;
            }
            int divisor = 2;
            while (divisor < term.length()) {
                if (term.length() % divisor == 0) {
                    flg = true;
                    break;
                }
                divisor++;
            }
            if (!flg || term.length() == 2) {
                newLst.add(term);
            }
        }
        return String.join(" ", newLst);
    }
}