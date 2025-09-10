public class HumanEval_94 {
    public static int skjkasdkd(int[] lst) {
        int maxx = 0;
        int i = 0;
        while (i < lst.length) {
            if (lst[i] > maxx && isPrime(lst[i])) {
                maxx = lst[i];
            }
            i++;
        }
        int result = sumOfDigits(maxx);
        return result;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        String numStr = Integer.toString(number);
        for (char digit : numStr.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}