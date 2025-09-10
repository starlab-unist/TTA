import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {

    public static List<Integer> parseNestedParens(String parenString) {
        List<Integer> result = new ArrayList<>();

        for (String x : parenString.split(" ")) {
            if (!x.isEmpty()) {
                result.add(parseParenGroup(x));
            }
        }

        return result;
    }

    private static int parseParenGroup(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}