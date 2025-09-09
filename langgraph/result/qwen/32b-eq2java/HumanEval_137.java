public class HumanEval_137 {
    public Object evaluateAndCompare(Object value1, Object value2) {
        String modifiedVal1 = value1.toString();
        String modifiedVal2 = value2.toString();
        
        if (modifiedVal1.contains(",")) {
            modifiedVal1 = modifiedVal1.replace(',', '.');
        }
        if (modifiedVal2.contains(",")) {
            modifiedVal2 = modifiedVal2.replace(',', '.');
        }

        double numericVal1 = Double.parseDouble(modifiedVal1);
        double numericVal2 = Double.parseDouble(modifiedVal2);

        if (numericVal1 == numericVal2) {
            return null;
        } else if (numericVal1 > numericVal2) {
            return value1;
        } else {
            return value2;
        }
    }
}