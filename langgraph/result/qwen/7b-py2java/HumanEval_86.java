public class HumanEval_86 {
    public static String antiShuffle(String s) {
        return String.join(" ", 
            java.util.Arrays.stream(s.split(" "))
                .map(str -> new StringBuilder(new String(
                    str.chars().sorted().toArray()))
                .toString())
                .toArray(String[]::new));
    }
}