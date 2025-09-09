import java.util.List;
import java.util.Optional;

public class HumanEval_12 {

    public static Optional<String> longest(List<String> strings) {
        if (strings.isEmpty()) {
            return Optional.empty();
        }

        int maxLength = 0;
        for (String s : strings) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        for (String s : strings) {
            if (s.length() == maxLength) {
                return Optional.of(s);
            }
        }

        return Optional.empty();
    }
}