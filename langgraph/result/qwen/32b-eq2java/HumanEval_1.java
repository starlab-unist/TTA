import java.util.ArrayList;
import java.util.List;

public class HumanEval_1 {

    public static List<String> extractBalancedParentheses(String inputSequence) {
        List<String> outputGroups = new ArrayList<>();
        StringBuilder tempGroup = new StringBuilder();
        int nestingLevel = 0;

        int index = 0;
        while (index < inputSequence.length()) {
            char character = inputSequence.charAt(index);
            if (character == '(') {
                nestingLevel++;
                tempGroup.append(character);
            } else if (character == ')') {
                nestingLevel--;
                tempGroup.append(character);

                if (nestingLevel == 0) {
                    outputGroups.add(tempGroup.toString());
                    tempGroup.setLength(0); // Clear the StringBuilder
                }
            }

            index++;
        }

        return outputGroups;
    }
}