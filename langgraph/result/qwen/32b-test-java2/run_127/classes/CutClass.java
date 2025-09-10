class HumanEval_127 {
    public String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        int start = Math.max(range1[0], range2[0]);
        int end = Math.min(range1[1], range2[1]);
        int span = end - start;
        if (span > 0 && primeCheck(span)) {
            return "YES";
        }
        return "NO";
    }

    private boolean primeCheck(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}