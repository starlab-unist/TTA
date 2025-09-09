class HumanEval_94 {
    public int skjkasdkd(int[] lst) {
        int maxx = 0;
        int i = 0;
        while (i < lst.length) {
            if (lst[i] > maxx && isPrime(lst[i])) {
                maxx = lst[i];
            }
            i++;
        }
        int result = sumOfDigits(maxx);
        return result;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}