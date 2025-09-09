public class HumanEval_112 {
    public static Pair<String, Boolean> reverseDelete(String s, String c) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!c.contains(String.valueOf(ch))) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        String reversed = new StringBuilder(result).reverse().toString();
        return new Pair<>(result, result.equals(reversed));
    }

    // Helper class to return two values
    public static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}