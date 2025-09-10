public class HumanEval_75 {

    public static boolean checkProductOfThreePrimes(int number) {
        for (int first = 2; first <= 100; first++) {
            if (!isPrime(first)) {
                continue;
            }
            for (int second = 2; second <= 100; second++) {
                if (!isPrime(second)) {
                    continue;
                }
                for (int third = 2; third <= 100; third++) {
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