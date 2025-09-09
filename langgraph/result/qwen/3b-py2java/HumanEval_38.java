public class HumanEval_38 {

    public static String encodeCyclic(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 3) {
            String group = s.substring(i, Math.min(i + 3, s.length()));
            if (group.length() == 3) {
                result.append(group.charAt(1)).append(group.charAt(0));
            } else {
                result.append(group);
            }
        }
        return result.toString();
    }

    public static String decodeCyclic(String s) {
        return encodeCyclic(encodeCyclic(s));
    }
}