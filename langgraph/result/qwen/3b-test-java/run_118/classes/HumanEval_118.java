public class HumanEval_118 {

    public static String findNearestIsolatedVowel(String sequence) {
        if (sequence.length() < 3) {
            return "";
        }

        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int index = sequence.length() - 3;

        while (index > 0) {
            char currentChar = sequence.charAt(index);
            if (vowelSet.contains(currentChar)) {
                if (!vowelSet.contains(sequence.charAt(index + 1)) && !vowelSet.contains(sequence.charAt(index - 1))) {
                    return String.valueOf(currentChar);
                }
            }
            index--;
        }

        return "";
    }
}