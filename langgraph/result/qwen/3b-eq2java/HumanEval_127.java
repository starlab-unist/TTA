public class HumanEval_127 {

    public static String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        int start = Math.max(range1[0], range2[0]);
        int end = Math.min(range1[1], range2[1]);
        int length = end - start;

        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
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
}