class HumanEval_59 {
    public int findMaxPrimeDivisor(int number) {
        boolean checkPrime(int candidate) {
            if (candidate < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor * divisor <= candidate) {
                if (candidate % divisor == 0) {
                    return false;
                }
                divisor++;
            }
            return true;
        }

        int maxPrime = 1;
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0 && checkPrime(factor)) {
                maxPrime = factor;
            }
            factor++;
        }
        return maxPrime;
    }
}