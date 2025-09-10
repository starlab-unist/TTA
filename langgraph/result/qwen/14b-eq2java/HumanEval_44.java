public class HumanEval_44 {
    public static String convertToBase(int number, int targetBase) {
        String result = "";
        while (number > 0) {
            int remainder = number % targetBase;
            result = remainder + result;
            number = number / targetBase;
        }
        return result;
    }
}