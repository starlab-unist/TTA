public class HumanEval_75 {
    public static boolean checkProductOfThreePrimes(int number) {
        int[] primeRange = new int[98];
        for (int i = 0; i < primeRange.length; i++) {
            primeRange[i] = i + 2;
        }

        for (int first : primeRange) {
            if (!isPrime(first)) {
                continue;
            }
            for (int second : primeRange) {
                if (!isPrime(second)) {
                    continue;
                }
                for (int third : primeRange) {
                    if (!isPrime(third)) {
                        continue;
                    }
                    if (first * second * third == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int value) {
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}