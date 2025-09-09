import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {

    public static List<Integer> parseNestedParens(String parenString) {
        List<Integer> result = new ArrayList<>();
        String[] groups = parenString.split(" ");

        for (String group : groups) {
            if (!group.isEmpty()) {
                int maxDepth = 0;
                int currentDepth = 0;
                for (char c : group.toCharArray()) {
                    if (c == '(') {
                        currentDepth++;
                        maxDepth = Math.max(maxDepth, currentDepth);
                    } else if (c == ')') {
                        currentDepth--;
                    }
                }
                result.add(maxDepth);
            }
        }

        return result;
    }
}