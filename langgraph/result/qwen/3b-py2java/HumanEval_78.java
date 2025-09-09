public class HumanEval_78 {
    public static int hexKey(String num) {
        String[] primes = {"2", "3", "5", "7", "B", "D"};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            if (isPrime(num.charAt(i), primes)) {
                total++;
            }
        }
        return total;
    }

    private static boolean isPrime(char c, String[] primes) {
        for (String prime : primes) {
            if (prime.equals(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}