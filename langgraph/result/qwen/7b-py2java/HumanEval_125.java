public class HumanEval_125 {
    public static Object splitWords(String txt) {
        if (txt.contains(" ")) {
            return Arrays.asList(txt.split("\\s+"));
        } else if (txt.contains(",")) {
            String[] parts = txt.replace(',', ' ').split("\\s+");
            return Arrays.asList(parts);
        } else {
            long count = txt.chars()
                             .filter(i -> Character.isLowerCase(i) && i % 2 == 0)
                             .count();
            return count;
        }
    }
}