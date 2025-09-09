public class HumanEval_65 {
    public static String circularShift(int x, int shift) {
        String s = Integer.toString(x);
        int length = s.length();
        
        if (shift >= length) {
            return new StringBuilder(s).reverse().toString();
        } else {
            int splitPoint = length - shift;
            String rotatedPart = s.substring(splitPoint);
            String remainingPart = s.substring(0, splitPoint);
            return rotatedPart + remainingPart;
        }
    }
}