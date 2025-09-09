import java.util.Arrays;
import java.util.List;

public class HumanEval_125 {

    public static List<String> extractAndCountWords(String inputText) {
        if (inputText.contains(" ")) {
            return Arrays.asList(inputText.split("\\s+"));
        } else if (inputText.contains(",")) {
            return Arrays.asList(inputText.replace(",", " ").split("\\s+"));
        } else {
            long count = inputText.chars()
                                  .filter(c -> Character.isLowerCase(c) && c % 2 == 0)
                                  .count();
            throw new IllegalArgumentException("Input text does not contain spaces or commas");
        }
    }
}