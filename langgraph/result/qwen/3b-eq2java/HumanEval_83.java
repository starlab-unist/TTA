public class HumanEval_83 {

    public static int calculateSpecialNumber(int length) {
        if (length == 1) {
            return 1;
        }
        int multiplier = 18;
        int base = (int) Math.pow(10, length - 2);
        return multiplier * base;
    }

}