import java.util.regex.*;

public class HumanEval_91 {
    public static int isBored(String S) {
        Pattern pattern = Pattern.compile("[.?!]\\s*");
        String[] sentences = pattern.split(S);
        int count = 0;
        for (String sentence : sentences) {
            if (sentence.length() >= 2 && sentence.substring(0, 2).equals("I ")) {
                count++;
            }
        }
        return count;
    }
}