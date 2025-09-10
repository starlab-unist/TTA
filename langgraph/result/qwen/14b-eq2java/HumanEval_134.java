public class HumanEval_134 {
    public static boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
        String[] words = inputString.split("\\s+");
        String lastWord = words[words.length - 1];
        return lastWord.length() == 1 && "a" <= lastWord.toLowerCase().charAt(0) && lastWord.toLowerCase().charAt(0) <= 'z';
    }
}