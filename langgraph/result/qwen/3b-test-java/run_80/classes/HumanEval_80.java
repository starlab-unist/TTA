public class HumanEval_80 {
    public static boolean checkHappiness(String sequence) {
        if (sequence.length() < 3) {
            return false;
        }

        int index = 0;
        while (index < sequence.length() - 2) {
            if (sequence.charAt(index) == sequence.charAt(index + 1) || 
                sequence.charAt(index + 1) == sequence.charAt(index + 2) || 
                sequence.charAt(index) == sequence.charAt(index + 2)) {
                return false;
            }
            index++;
        }

        return true;
    }
}