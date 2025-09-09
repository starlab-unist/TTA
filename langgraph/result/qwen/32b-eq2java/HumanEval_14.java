import java.util.ArrayList;
import java.util.List;

public class HumanEval_14 {

    public List<String> generateStringPrefixes(String inputStr) {
        List<String> prefixes = new ArrayList<>();
        int index = 0;

        while (index < inputStr.length()) {
            prefixes.add(inputStr.substring(0, index + 1));
            index++;
        }

        return prefixes;
    }
}