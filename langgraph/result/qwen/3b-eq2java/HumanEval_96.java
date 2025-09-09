public class HumanEval_96 {

    public static List<Integer> findPrimesBelow(int limit) {
        List<Integer> primeNumbers = new ArrayList<>();
        int candidate = 2;
        while (candidate < limit) {
            boolean isDivisible = false;
            int divisor = 2;
            while (divisor < candidate) {
                if (candidate % divisor == 0) {
                    isDivisible = true;
                    break;
                }
                divisor++;
            }
            if (!isDivisible) {
                primeNumbers.add(candidate);
            }
            candidate++;
        }
        return primeNumbers;
    }

}