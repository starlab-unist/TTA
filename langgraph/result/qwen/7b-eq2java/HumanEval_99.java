public class HumanEval_99 {
    public static int nearestWholeNumber(String input_value) {
        if (input_value.contains(".")) {
            // strip trailing zeros
            while (input_value.endsWith("0")) {
                input_value = input_value.substring(0, input_value.length() - 1);
            }
        }

        double number = Double.parseDouble(input_value);
        if (input_value.endsWith(".5")) {
            result = number > 0 ? (int)Math.ceil(number) : (int)Math.floor(number);
        } else if (!input_value.isEmpty()) {
            result = (int)Math.round(number);
        } else {
            result = 0;
        }

        return result;
    }
}