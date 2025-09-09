import java.util.ArrayList;
import java.util.List;

public class HumanEval_11 {
    public String binaryStringDifference(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < str1.length()) {
            result.append(bitDiff(str1.charAt(index), str2.charAt(index)));
            index++;
        }
        return result.toString();
    }

    private char bitDiff(char c1, char c2) {
        return c1 == c2 ? '0' : '1';
    }
}