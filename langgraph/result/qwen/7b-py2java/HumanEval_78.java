public class HumanEval_78 {
    public static int hexKey(String num) {
        char[] primes = {'2', '3', '5', '7', 'B', 'D'};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            if (isPrime(num.charAt(i), primes)) {
                total++;
            }
        }
        return total;
    }

    private static boolean isPrime(char ch, char[] primes) {
        for (char prime : primes) {
            if (ch == prime) {
                return true;
            }
        }
        return false;
    }
}