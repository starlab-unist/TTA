public class HumanEval_99 {

    public static int closestInteger(String value) {
        // Remove trailing zeros
        while (value.endsWith("0")) {
            value = value.substring(0, value.length() - 1);
        }

        double num = Double.parseDouble(value);

        if (value.endsWith(".5")) {
            if (num > 0) {
                return (int) Math.ceil(num);
            } else {
                return (int) Math.floor(num);
            }
        } else {
            return (int) Math.round(num);
        }
    }
}