public class HumanEval_39 {

    public static int findNthPrimeFibonacci(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Index must be a positive integer.");
        }

        int[] fibonacciSequence = new int[2];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        int nextFib = 0;
        while (true) {
            nextFib = fibonacciSequence[0] + fibonacciSequence[1];
            fibonacciSequence[0] = fibonacciSequence[1];
            fibonacciSequence[1] = nextFib;

            if (isPrime(nextFib)) {
                index--;
            }
            if (index == 0) {
                return nextFib;
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int limit = Math.min((int) Math.sqrt(number) + 1, number - 1);
        for (int divisor = 2; divisor < limit; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}