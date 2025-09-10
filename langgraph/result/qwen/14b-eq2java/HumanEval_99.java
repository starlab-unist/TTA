public class HumanEval_99 {
    public static int nearestWholeNumber(String inputValue) {
        if (inputValue.contains(".")) {
            // strip trailing zeros
            while (inputValue.endsWith("0")) {
                inputValue = inputValue.substring(0, inputValue.length() - 1);
            }
        }

        double number = Double.parseDouble(inputValue);
        if (inputValue.endsWith(".5")) {
            result = number > 0 ? Math.ceil(number) : Math.floor(number);
        } else if (!inputValue.isEmpty()) {
            result = (int) Math.round(number);
        } else {
            result = 0;
        }

        return result;
    }
}