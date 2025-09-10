public class HumanEval_56 {
    public static boolean validateBracketSequence(String sequence) {
        int level = 0;
        int index = 0;
        while (index < sequence.length()) {
            if (sequence.charAt(index) == '<') {
                level += 1;
            } else {
                level -= 1;
            }
            if (level < 0) {
                return false;
            }
            index += 1;
        }
        return level == 0;
    }
}