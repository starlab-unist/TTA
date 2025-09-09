public class HumanEval_16 {
    public static int countDistinctCharacters(String string) {
        return new HashSet<>(Arrays.asList(string.toLowerCase().split("")))
                .size();
    }
}