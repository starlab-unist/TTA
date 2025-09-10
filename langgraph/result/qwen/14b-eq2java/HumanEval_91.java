import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HumanEval_91 {

    public static int countPersonalStatements(String text) {
        String[] segments = text.split("[.?!]\\s*");
        int personalStatementCount = 0;

        for (String segment : segments) {
            if (segment.startsWith("I ")) {
                personalStatementCount++;
            }
        }

        return personalStatementCount;
    }
}