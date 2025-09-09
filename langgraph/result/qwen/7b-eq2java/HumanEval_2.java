public class HumanEval_2 {
    public static double extractDecimalPart(double value) {
        double decimalPart = value - Math.floor(value);
        return decimalPart;
    }
}