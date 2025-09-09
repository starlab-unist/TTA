public class HumanEval_134 {
    public boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
        String[] words = inputString.split(" ");
        String lastWord = words[words.length - 1];
        return lastWord.length() == 1 && lastWord.toLowerCase().matches("[a-z]");
    }
}