public class HumanEval_127 {
    public static String intersection(int[] interval1, int[] interval2) {
        boolean isPrime(int num) {
            if (num == 1 || num == 0) {
                return false;
            }
            if (num == 2) {
                return true;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        int l = Math.max(interval1[0], interval2[0]);
        int r = Math.min(interval1[1], interval2[1]);
        int length = r - l;
        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }
}