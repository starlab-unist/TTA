public class HumanEval_48 {
    public static boolean check_palindrome(String sequence) {
        int index = 0;
        int length = sequence.length();
        
        while (index < length / 2) {
            if (sequence.charAt(index) != sequence.charAt(length - index - 1)) {
                return false;
            }
            index += 1;
        }
        return true;
    }
}