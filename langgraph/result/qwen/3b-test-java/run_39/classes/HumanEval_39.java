public class HumanEval_39 {

    public static long findNthPrimeFibonacci(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Index must be a positive integer.");
        }

        long a = 0;
        long b = 1;
        int count = 0;

        while (true) {
            long next = a + b;
            a = b;
            b = next;

            if (isPrime(next)) {
                count++;
            }

            if (count == index) {
                return next;
            }
        }
    }

    private static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }

        long limit = Math.min((long) Math.sqrt(number), number - 1);
        long divisor = 2;
        while (divisor <= limit) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}