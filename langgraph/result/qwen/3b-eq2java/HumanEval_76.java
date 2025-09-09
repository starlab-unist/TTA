public class HumanEval_76 {

    public static boolean isSimplePower(int base, int exponent) {
        if (exponent == 1) {
            return base == 1;
        }

        int power = 1;
        while (power < base) {
            power *= exponent;
        }

        return power == base;
    }
}