public class HumanEval_64 {

    public static int vowelsCount(String s) {
        String vowels = "aeiouAEIOU";
        int nVowels = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                nVowels++;
            }
        }
        if (s.charAt(s.length() - 1) == 'y' || s.charAt(s.length() - 1) == 'Y') {
            nVowels++;
        }
        return nVowels;
    }

}