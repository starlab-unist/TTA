public class HumanEval_27 {
    public static String flipCase(String string) {
        return string == null ? null : string.chars()
            .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}