import java.util.ArrayList;
import java.util.List;

public class HumanEval_1 {

    public static List<String> extractBalancedParentheses(String parenString) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int currentDepth = 0;

        int index = 0;
        while (index < parenString.length()) {
            char character = parenString.charAt(index);
            if (character == '(') {
                currentDepth++;
                currentString.append(character);
            } else if (character == ')') {
                currentDepth--;
                currentString.append(character);

                if (currentDepth == 0) {
                    result.add(currentString.toString());
                    currentString.setLength(0);
                }
            }

            index++;
        }

        return result;
    }
}