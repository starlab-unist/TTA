import java.util.List;
import java.util.Optional;

public class HumanEval_12 {

    public static Optional<String> findLongestString(List<String> strings) {
        if (strings.isEmpty()) {
            return Optional.empty();
        }

        int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);
        for (String s : strings) {
            if (s.length() == maxLength) {
                return Optional.of(s);
            }
        }

        return Optional.empty();
    }
}