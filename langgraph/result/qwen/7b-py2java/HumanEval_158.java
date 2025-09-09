import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_158 {
    public static String findMax(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int lenCompare = Integer.compare(s2.length(), s1.length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                return s1.compareTo(s2);
            }
        });
        return words[0];
    }
}