public class HumanEval_51 {
    public String stripVowels(String inputString) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < inputString.length()) {
            char ch = inputString.charAt(index);
            if (vowels.indexOf(ch) == -1) {
                result.append(ch);
            }
            index++;
        }

        return result.toString();
    }
}