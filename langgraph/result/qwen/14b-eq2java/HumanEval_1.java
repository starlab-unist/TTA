import java.util.ArrayList;
import java.util.List;

public class HumanEval_1 {

    public static List<String> extractBalancedParentheses(String inputSequence) {
        List<String> outputGroups = new ArrayList<>();
        List<Character> tempGroup = new ArrayList<>();
        int nestingLevel = 0;

        int index = 0;
        while (index < inputSequence.length()) {
            char character = inputSequence.charAt(index);
            if (character == '(') {
                nestingLevel += 1;
                tempGroup.add(character);
            } else if (character == ')') {
                nestingLevel -= 1;
                tempGroup.add(character);

                if (nestingLevel == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : tempGroup) {
                        sb.append(c);
                    }
                    outputGroups.add(sb.toString());
                    tempGroup.clear();
                }
            }

            index += 1;
        }

        return outputGroups;
    }
}