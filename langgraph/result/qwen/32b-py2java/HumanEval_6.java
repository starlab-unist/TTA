import java.util.ArrayList;
import java.util.List;

class HumanEval_6 {
    public static List<Integer> parseNestedParens(String parenString) {
        List<Integer> result = new ArrayList<>();
        
        for (String s : parenString.split(" ")) {
            if (!s.isEmpty()) {
                result.add(parseParenGroup(s));
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
            } else {
                depth--;
            }
        }
        
        return maxDepth;
    }
}