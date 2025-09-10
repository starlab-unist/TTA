public class HumanEval_16 {
    public static int countDistinctCharacters(String string) {
        return (int) string.toLowerCase().chars().distinct().count();
    }
}