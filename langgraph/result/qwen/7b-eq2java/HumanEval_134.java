public class HumanEval_134 {
    public static boolean checkIfLastCharIsALetter(String txt) {
        String[] words = txt.rsplit(" ", 1);
        String check = words[words.length - 1];
        return check.length() == 1 && Character.isLetter(check.charAt(0));
    }
}