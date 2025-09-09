public class HumanEval_44 {
    public String convertToBase(int number, int targetBase) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % targetBase;
            result.insert(0, remainder);
            number = number / targetBase;
        }
        return result.toString();
    }
}