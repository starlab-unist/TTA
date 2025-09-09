public class HumanEval_89 {

    public static String encrypt(String s) {
        String d = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder out = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (d.indexOf(c) != -1) {
                int index = (d.indexOf(c) + 2 * 2) % 26;
                out.append(d.charAt(index));
            } else {
                out.append(c);
            }
        }
        
        return out.toString();
    }

}