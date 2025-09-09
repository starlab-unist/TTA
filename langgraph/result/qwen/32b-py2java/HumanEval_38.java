class HumanEval_38 {

    public static String encodeCyclic(String s) {
        StringBuilder encoded = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i += 3) {
            String group = s.substring(i, Math.min(i + 3, length));
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