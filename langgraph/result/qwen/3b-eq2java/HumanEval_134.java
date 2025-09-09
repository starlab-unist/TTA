public class HumanEval_134 {

    public static boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
        String lastWord = inputString.split(" ", -1)[inputString.split(" ").length - 1];
        return lastWord.length() == 1 && lastWord.toLowerCase().equals("a");
    }
}