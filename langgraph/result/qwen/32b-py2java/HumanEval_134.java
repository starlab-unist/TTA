public class HumanEval_134 {
    public boolean checkIfLastCharIsALetter(String txt) {
        String[] parts = txt.split(" ");
        String check = parts[parts.length - 1];
        return check.length() == 1 && (check.toLowerCase().charAt(0) >= 'a' && check.toLowerCase().charAt(0) <= 'z');
    }
}