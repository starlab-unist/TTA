public class HumanEval_78 {
    public static int hexKey(String num) {
        String[] primes = {"2", "3", "5", "7", "B", "D"};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            for (String prime : primes) {
                if (Character.toString(num.charAt(i)).equals(prime)) {
                    total += 1;
                    break;
                }
            }
        }
        return total;
    }
}