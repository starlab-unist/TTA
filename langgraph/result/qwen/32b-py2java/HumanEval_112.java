class HumanEval_112 {
    public static java.util.AbstractMap.SimpleEntry<String, Boolean> reverseDelete(String s, String c) {
        StringBuilder filtered = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (c.indexOf(ch) == -1) {
                filtered.append(ch);
            }
        }
        String result = filtered.toString();
        String reversed = filtered.reverse().toString();
        return new java.util.AbstractMap.SimpleEntry<>(result, result.equals(reversed));
    }
}