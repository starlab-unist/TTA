public class HumanEval_51 {
    public static String removeVowels(String inputString) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < inputString.length()) {
            char ch = inputString.charAt(index);
            if (!vowels.contains(ch)) {
                result.append(ch);
            }
            index++;
        }

        return result.toString();
    }
}