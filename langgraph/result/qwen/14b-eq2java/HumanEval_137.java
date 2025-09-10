public class HumanEval_137 {
    public static Object evaluate_and_compare(Object value1, Object value2) {
        String modified_val1 = value1.toString();
        String modified_val2 = value2.toString();

        if (modified_val1.contains(",")) {
            modified_val1 = modified_val1.replace(',', '.');
        }
        if (modified_val2.contains(",")) {
            modified_val2 = modified_val2.replace(',', '.');
        }

        double numeric_val1 = Double.parseDouble(modified_val1);
        double numeric_val2 = Double.parseDouble(modified_val2);

        if (numeric_val1 == numeric_val2) {
            return null;
        } else if (numeric_val1 > numeric_val2) {
            return value1;
        } else {
            return value2;
        }
    }
}