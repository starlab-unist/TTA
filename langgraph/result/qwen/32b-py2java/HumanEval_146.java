public class HumanEval_146 {

    public static int specialFilter(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num > 10) {
                String numberAsString = Integer.toString(num);
                int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
                int lastDigit = Character.getNumericValue(numberAsString.charAt(numberAsString.length() - 1));
                if ((firstDigit == 1 || firstDigit == 3 || firstDigit == 5 || firstDigit == 7 || firstDigit == 9) &&
                    (lastDigit == 1 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7 || lastDigit == 9)) {
                    count++;
                }
            }
        }
        return count;
    }
}