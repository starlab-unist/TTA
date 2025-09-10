import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {

    public static List<Integer> analyze_parentheses_depth(String paren_sequence) {
        List<Integer> result = new ArrayList<>();

        for (String segment : paren_sequence.split("\\s+")) {
            if (!segment.isEmpty()) {
                result.add(calculate_max_nesting_level(segment));
            }
        }

        return result;
    }

    private static int calculate_max_nesting_level(String substring) {
        int current_level = 0;
        int peak_level = 0;

        for (char character : substring.toCharArray()) {
            if (character == '(') {
                current_level += 1;
                peak_level = Math.max(current_level, peak_level);
            } else if (character == ')') {
                current_level -= 1;
            }
        }

        return peak_level;
    }
}