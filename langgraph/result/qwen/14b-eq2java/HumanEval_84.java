public class HumanEval_84 {
    public static String convertToBinaryString(int number) {
        int digitSum = 0;
        String numberStr = Integer.toString(number);
        
        for (char digit : numberStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        
        String binaryRepresentation = Integer.toBinaryString(digitSum);
        return binaryRepresentation;
    }
}