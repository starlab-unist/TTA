import java.util.Set;
import java.util.HashSet;

public class HumanEval_16 {
    public static int countDistinctCharacters(String string) {
        return new HashSet<>(Set.of(string.toLowerCase().split(""))).size();
    }
}