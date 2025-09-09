class HumanEval_75 {
    public boolean checkProductOfThreePrimes(int number) {
        for (int first : primeRange()) {
            if (!primeCheck(first)) {
                continue;
            }
            for (int second : primeRange()) {
                if (!primeCheck(second)) {
                    continue;
                }
                for (int third : primeRange()) {
                    if (!primeCheck(third)) {
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

    private boolean primeCheck(int value) {
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] primeRange() {
        int[] range = new int[99];
        for (int i = 0; i < range.length; i++) {
            range[i] = i + 2;
        }
        return range;
    }
}