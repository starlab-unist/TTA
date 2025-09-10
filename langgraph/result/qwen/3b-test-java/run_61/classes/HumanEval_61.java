public class HumanEval_61 {

    public static boolean validateParentheses(String sequence) {
        int balance = 0;
        int index = 0;
        while (index < sequence.length()) {
            if (sequence.charAt(index) == '(') {
                balance++;
            } else if (sequence.charAt(index) == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
            index++;
        }
        return balance == 0;
    }

}