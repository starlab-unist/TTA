import java.util.ArrayList;
import java.util.List;

public class HumanEval_1 {

    public static List<String> separateParenGroups(String parenString) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int currentDepth = 0;

        for (char c : parenString.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                currentString.append(c);
            } else if (c == ')') {
                currentDepth--;
                currentString.append(c);

                if (currentDepth == 0) {
                    result.add(currentString.toString());
                    currentString.setLength(0);
                }
            }
        }

        return result;
    }
}