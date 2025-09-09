public class HumanEval_82 {
    public static boolean checkPrimeStringLength(String inputText) {
        int stringLength = inputText.length();
        if (stringLength < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor < stringLength) {
            if (stringLength % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}