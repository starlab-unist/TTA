import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HumanEval_91 {
    public int countPersonalStatements(String text) {
        Pattern pattern = Pattern.compile("[.?!]\\s*");
        String[] segments = pattern.split(text);
        int personalStatementCount = 0;

        for (String segment : segments) {
            if (segment.startsWith("I ")) {
                personalStatementCount++;
            }
        }

        return personalStatementCount;
    }
}