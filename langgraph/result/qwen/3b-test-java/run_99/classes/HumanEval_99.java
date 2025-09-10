public class HumanEval_99 {
    public static int nearestWholeNumber(String inputValue) {
        if (inputValue.contains(".")) {
            // Strip trailing zeros
            while (inputValue.endsWith("0")) {
                inputValue = inputValue.substring(0, inputValue.length() - 1);
            }
        }

        double number = Double.parseDouble(inputValue);
        if (inputValue.endsWith(".5")) {
            int result = (number > 0) ? (int) Math.ceil(number) : (int) Math.floor(number);
        } else if (!inputValue.isEmpty()) {
            int result = (int) Math.round(number);
        } else {
            return 0;
        }

        return result;
    }
}