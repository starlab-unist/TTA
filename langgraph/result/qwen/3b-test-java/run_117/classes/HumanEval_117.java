public class HumanEval_117 {

    public static List<String> filterWordsByConsonantCount(String inputString, int targetConsonantCount) {
        List<String> selectedWords = new ArrayList<>();
        String[] words = inputString.split("\\s+");

        for (String word : words) {
            int consonantCounter = 0;
            int index = 0;
            while (index < word.length()) {
                char c = Character.toLowerCase(word.charAt(index));
                if ("aeiou".indexOf(c) == -1) {
                    consonantCounter++;
                }
                index++;
            }

            if (consonantCounter == targetConsonantCount) {
                selectedWords.add(word);
            }
        }

        return selectedWords;
    }
}