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

        int result = 0;
        String maxStr = Integer.toString(maxx);
        for (char digit : maxStr.toCharArray()) {
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