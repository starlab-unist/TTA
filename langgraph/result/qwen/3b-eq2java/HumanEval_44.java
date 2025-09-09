public class HumanEval_44 {
    public static String convertToBase(int number, int targetBase) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % targetBase;
            result.append(remainder);
            number /= targetBase;
        }
        return result.toString();
    }
}