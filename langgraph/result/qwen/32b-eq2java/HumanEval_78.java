import java.util.Set;
import java.util.HashSet;

public class HumanEval_78 {
    public int countPrimeHexDigits(String hexString) {
        Set<Character> primeHexDigits = new HashSet<>(Set.of('2', '3', '5', '7', 'B', 'D'));
        int count = 0;
        int index = 0;
        while (index < hexString.length()) {
            if (primeHexDigits.contains(hexString.charAt(index))) {
                count += 1;
            }
            index += 1;
        }
        return count;
    }
}