public class HumanEval_51 {
    public static String removeVowels(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (!"aeiouAEIOU".contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }
}