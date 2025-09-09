public class HumanEval_54 {

    public static boolean sameChars(String s0, String s1) {
        return new HashSet<Character>(s0.chars().boxed().collect(Collectors.toList())).equals(new HashSet<Character>(s1.chars().boxed().collect(Collectors.toList())));
    }
}