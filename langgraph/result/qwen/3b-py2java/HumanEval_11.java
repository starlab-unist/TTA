import java.util.stream.Collectors;

public class HumanEval_11 {

    public static String stringXor(String a, String b) {
        return a.chars()
                .zip(b.chars(), (x, y) -> xor(x, y))
                .mapToObj(c -> String.valueOf(c))
                .collect(Collectors.joining());
    }

    private static char xor(int i, int j) {
        if (i == j) {
            return '0';
        } else {
            return '1';
        }
    }
}