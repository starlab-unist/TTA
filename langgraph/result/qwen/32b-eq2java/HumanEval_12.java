import java.util.List;
import java.util.Optional;

public class HumanEval_12 {

    public static Optional<String> findLongestString(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return Optional.empty();
        }

        int maxLength = stringList.stream().mapToInt(String::length).max().orElse(0);
        for (String element : stringList) {
            if (element.length() == maxLength) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }
}