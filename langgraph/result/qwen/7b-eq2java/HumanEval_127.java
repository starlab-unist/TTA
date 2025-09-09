public class HumanEval_127 {
    public static String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        boolean isPrime(int number) {
            if (number == 0 || number == 1) {
                return false;
            }
            if (number == 2) {
                return true;
            }
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        int l = Math.max(range1[0], range2[0]);
        int r = Math.min(range1[1], range2[1]);
        int length = r - l;
        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }
}