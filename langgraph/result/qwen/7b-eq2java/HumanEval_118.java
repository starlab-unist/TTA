public class HumanEval_118 {
    public static String getClosestVowel(String word) {
        if (word.length() < 3) {
            return "";
        }

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int index = word.length() - 3;

        while (index > 0) {
            if (vowels.contains(word.charAt(index))) {
                if (!vowels.contains(word.charAt(index + 1)) && !vowels.contains(word.charAt(index - 1))) {
                    return String.valueOf(word.charAt(index));
                }
            }
            index--;
        }

        return "";
    }
}