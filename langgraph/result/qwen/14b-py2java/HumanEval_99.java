public class HumanEval_99 {
    public static int closestInteger(String value) {
        if (value.contains(".") && value.indexOf('.') != value.lastIndexOf('.')) {
            throw new IllegalArgumentException("Invalid input: more than one decimal point");
        }

        // remove trailing zeros
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
        } else if (value.length() > 0) {
            return (int) Math.round(num);
        } else {
            return 0;
        }
    }
}