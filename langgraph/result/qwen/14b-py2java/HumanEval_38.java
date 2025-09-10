public class HumanEval_38 {
    public static String encodeCyclic(String s) {
        // split string to groups. Each of length 3.
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < s.length(); i += 3) {
            String group = s.substring(i, Math.min(i + 3, s.length()));
            // cycle elements in each group. Unless group has fewer elements than 3.
            if (group.length() == 3) {
                group = group.substring(1) + group.charAt(0);
            }
            encoded.append(group);
        }
        return encoded.toString();
    }

    public static String decodeCyclic(String s) {
        return encodeCyclic(encodeCyclic(s));
    }
}