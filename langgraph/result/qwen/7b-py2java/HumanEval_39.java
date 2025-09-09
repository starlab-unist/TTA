import java.util.ArrayList;
import java.math.BigInteger;

public class HumanEval_39 {

    public static BigInteger primeFib(int n) {
        ArrayList<BigInteger> f = new ArrayList<>();
        f.add(BigInteger.ZERO);
        f.add(BigInteger.ONE);

        while (true) {
            f.add(f.get(f.size() - 1).add(f.get(f.size() - 2)));
            if (isPrime(f.get(f.size() - 1))) {
                n--;
            }
            if (n == 0) {
                return f.get(f.size() - 1);
            }
        }
    }

    private static boolean isPrime(BigInteger p) {
        if (p.compareTo(BigInteger.valueOf(2)) < 0) {
            return false;
        }
        for (int k = 2; k <= Math.min((int) Math.sqrt(p.doubleValue()), p.intValue() - 1); k++) {
            if (p.mod(BigInteger.valueOf(k)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}