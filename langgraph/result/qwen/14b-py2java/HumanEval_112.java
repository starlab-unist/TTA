public class HumanEval_112 {
    public static Object[] reverseDelete(String s, String c) {
        StringBuilder filtered = new StringBuilder();
        for (char charInS : s.toCharArray()) {
            if (c.indexOf(charInS) == -1) {
                filtered.append(charInS);
            }
        }
        String result = filtered.toString();
        boolean isPalindrome = result.equals(filtered.reverse().toString());
        return new Object[]{result, isPalindrome};
    }
}