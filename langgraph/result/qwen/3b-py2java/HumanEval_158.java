public class HumanEval_158 {

    public static String findMax(String[] words) {
        return Arrays.stream(words)
                .sorted(Comparator.comparingInt(word -> -word.length())
                        .thenComparing(word -> word))
                .findFirst()
                .orElse(null);
    }
}