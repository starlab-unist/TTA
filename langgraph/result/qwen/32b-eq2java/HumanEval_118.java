public class HumanEval_118 {
    public String findNearestIsolatedVowel(String sequence) {
        if (sequence.length() < 3) {
            return "";
        }

        String vowels = "aeiouAEIOU";
        int index = sequence.length() - 3;

        while (index > 0) {
            if (vowels.indexOf(sequence.charAt(index)) != -1) {
                if (vowels.indexOf(sequence.charAt(index + 1)) == -1 && vowels.indexOf(sequence.charAt(index - 1)) == -1) {
                    return String.valueOf(sequence.charAt(index));
                }
            }
            index--;
        }

        return "";
    }
}