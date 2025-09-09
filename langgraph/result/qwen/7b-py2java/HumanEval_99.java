public class HumanEval_99 {
    public static int closestInteger(String value) {
        double num;
        try {
            num = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (value.contains(".")) {
            // remove trailing zeros
            while (value.endsWith("0")) {
                value = value.substring(0, value.length() - 1);
            }
        }

        if (value.endsWith(".5")) {
            if (num > 0) {
                return (int) Math.ceil(num);
            } else {
                return (int) Math.floor(num);
            }
        } else if (!value.isEmpty()) {
            return (int) Math.round(num);
        } else {
            return 0;
        }
    }
}