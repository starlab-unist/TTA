public class HumanEval_61 {
    public static boolean correct_bracketing(String brackets) {
        int depth = 0;
        for (char b : brackets.toCharArray()) {
            if (b == '(') {
                depth += 1;
            } else {
                depth -= 1;
            }
            if (depth < 0) {
                return false;
            }
        }
        return depth == 0;
    }
}