import java.lang.Math;

public class HumanEval_99 {
    public static int closestInteger(String value) {
        if (value.contains(".")) {
            // Remove trailing zeros
            while (value.endsWith("0")) {
                value = value.substring(0, value.length() - 1);
            }
        }

        double num = Double.parseDouble(value);
        int res;
        if (value.endsWith(".5")) {
            if (num > 0) {
                res = (int) Math.ceil(num);
            } else {
                res = (int) Math.floor(num);
            }
        } else if (!value.isEmpty()) {
            res = (int) Math.round(num);
        } else {
            res = 0;
        }

        return res;
    }
}