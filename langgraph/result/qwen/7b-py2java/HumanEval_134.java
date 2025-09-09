public class HumanEval_134 {
    public static boolean checkIfLastCharIsALetter(String txt) {
        String[] words = txt.split(" ");
        String lastWord = words[words.length - 1];
        return lastWord.length() == 1 && (lastWord.charAt(0) >= 'a' && lastWord.charAt(0) <= 'z') || (lastWord.charAt(0) >= 'A' && lastWord.charAt(0) <= 'Z');
    }
}