public class HumanEval_78 {
    public int hexKey(String num) {
        String[] primes = {"2", "3", "5", "7", "B", "D"};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            if (contains(primes, String.valueOf(num.charAt(i)))) {
                total += 1;
            }
        }
        return total;
    }

    private boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}