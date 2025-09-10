public class HumanEval_11 {
    public static String binaryStringDifference(String str1, String str2) {
        return bitDiff(str1, str2);
    }

    private static String bitDiff(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < str1.length()) {
            result.append(str1.charAt(index) == str2.charAt(index) ? '0' : '1');
            index++;
        }
        return result.toString();
    }
}