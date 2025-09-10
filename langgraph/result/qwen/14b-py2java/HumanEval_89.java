public class HumanEval_89 {
    public static String encrypt(String s) {
        String d = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder out = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = d.indexOf(c);
            if (index != -1) {
                out.append(d.charAt((index + 2 * 2) % 26));
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}