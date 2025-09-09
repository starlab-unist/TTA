public class HumanEval_2 {

    public static float extractDecimalPart(float value) {
        float decimalPart = value - (int) value;
        return decimalPart;
    }
}