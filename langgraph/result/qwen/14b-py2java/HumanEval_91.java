import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HumanEval_91 {
    public static int isBored(String S) {
        String[] sentences = S.split("[.?!]\\s*");
        int count = 0;
        for (String sentence : sentences) {
            if (sentence.startsWith("I ")) {
                count++;
            }
        }
        return count;
    }
}