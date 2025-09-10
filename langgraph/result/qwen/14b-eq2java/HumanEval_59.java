public class HumanEval_59 {
    public static int findMaxPrimeDivisor(int number) {
        int maxPrime = 1;
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0 && checkPrime(factor)) {
                maxPrime = factor;
            }
            factor += 1;
        }
        return maxPrime;
    }

    private static boolean checkPrime(int candidate) {
        if (candidate < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor * divisor <= candidate) {
            if (candidate % divisor == 0) {
                return false;
            }
            divisor += 1;
        }
        return true;
    }
}