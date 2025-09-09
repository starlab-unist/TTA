public class HumanEval_125 {

    public static List<String> extractAndCountWords(String inputText) {
        if (inputText.contains(" ")) {
            String[] wordList = inputText.split(" ");
        } else if (inputText.contains(",")) {
            String[] wordList = inputText.replace(",", " ").split(" ");
        } else {
            int count = 0;
            for (char c : inputText.toCharArray()) {
                if (Character.isLowerCase(c) && (c - 'a') % 2 == 0) {
                    count++;
                }
            }
            return Collections.singletonList(Integer.toString(count));
        }

        return Arrays.asList(wordList);
    }
}