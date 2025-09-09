public class HumanEval_94 {
    public static int skjkasdkd(List<Integer> lst) {
        int max = 0;
        for (int num : lst) {
            if (num > max && isPrime(num)) {
                max = num;
            }
        }
        int result = 0;
        for (char digit : String.valueOf(max).toCharArray()) {
            result += Character.getNumericValue(digit);
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}