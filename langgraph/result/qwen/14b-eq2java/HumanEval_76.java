public class HumanEval_76 {
    public static boolean checkPowerRelation(int base, int exponent) {
        if (exponent == 1) {
            return base == 1;
        }
        
        int currentValue = 1;
        while (currentValue < base) {
            currentValue *= exponent;
        }
        
        return currentValue == base;
    }
}