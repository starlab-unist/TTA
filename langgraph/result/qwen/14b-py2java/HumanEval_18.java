public class HumanEval_18 {
    public static int howManyTimes(String string, String substring) {
        int times = 0;

        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.substring(i, i + substring.length()).equals(substring)) {
                times++;
            }
        }

        return times;
    }
}