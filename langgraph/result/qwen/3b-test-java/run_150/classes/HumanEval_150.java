public class HumanEval_150 {

    public static int determineValueBasedOnDivisibility(int number, int valueIfNotPrime, int valueIfPrime) {
        if (number == 1) {
            return valueIfPrime;
        }

        int divisor = 2;
        while (divisor < number) {
            if (number % divisor == 0) {
                return valueIfPrime;
            }
            divisor++;
        }
        return valueIfNotPrime;
    }
}