public class HumanEval_134 {

    public static boolean checkIfLastCharIsALetter(String txt) {
        String[] words = txt.split(" ");
        if (words.length == 0) {
            return false;
        }
        String lastWord = words[words.length - 1];
        return lastWord.length() == 1 && (lastWord.charAt(0) >= 'a' && lastWord.charAt(0) <= 'z');
    }

}