public class HumanEval_98 {
    public static int countUpper(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if ("AEIOU".indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
}