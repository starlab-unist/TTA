public class HumanEval_65 {
    public static String rotateString(int number, int offset) {
        String numStr = Integer.toString(number);
        int length = numStr.length();
        
        if (offset >= length) {
            return new StringBuilder(numStr).reverse().toString();
        } else {
            int splitPoint = length - offset;
            String rotatedPart = numStr.substring(splitPoint);
            String remainingPart = numStr.substring(0, splitPoint);
            return rotatedPart + remainingPart;
        }
    }
}