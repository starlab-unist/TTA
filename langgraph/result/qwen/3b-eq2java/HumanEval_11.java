import java.util.List;

public class HumanEval_11 {

    public static String binaryStringDifference(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < str1.length()) {
            char c1 = str1.charAt(index);
            char c2 = str2.charAt(index);
            result.append(bitDiff(c1, c2));
            index++;
        }

        return result.toString();
    }

    private static char bitDiff(char c1, char c2) {
        return c1 == c2 ? '0' : '1';
    }
}