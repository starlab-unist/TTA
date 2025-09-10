public class HumanEval_75 {

    public static boolean checkProductOfThreePrimes(int number) {
        // Helper method to check if a number is prime
        boolean isPrime(int value) {
            for (int divisor = 2; divisor < value; divisor++) {
                if (value % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        // Define the range of prime numbers to check
        int[] primeRange = new int[100];
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                primeRange[count++] = i;
            }
        }

        // Iterate through all combinations of three primes
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    if (primeRange[i] * primeRange[j] * primeRange[k] == number) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}