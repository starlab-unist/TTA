public class HumanEval_86 {

    public static String orderWordsCharacters(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedWord = new String(chars);
            result.append(sortedWord).append(" ");
        }

        return result.toString().trim();
    }
}