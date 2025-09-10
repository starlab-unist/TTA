public class HumanEval_51 {
    public static String strip_vowels(String input_string) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < input_string.length()) {
            char charAt = input_string.charAt(index);
            if (!vowels.contains(charAt)) {
                result.append(charAt);
            }
            index++;
        }

        return result.toString();
    }
}