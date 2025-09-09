public class HumanEval_39 {

    public static long findNthPrimeFibonacci(int n) {
        boolean[] prime = new boolean[n * 50]; // Adjust size as needed
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        int count = 0;
        long a = 0, b = 1, c = 0;

        while (true) {
            c = a + b;
            a = b;
            b = c;

            if (isPrime(c, prime)) {
                count++;
                if (count == n) {
                    return c;
                }
            }
        }
    }

    private static boolean isPrime(long number, boolean[] prime) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (!prime[i]) continue;
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}