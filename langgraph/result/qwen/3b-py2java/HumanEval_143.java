public class HumanEval_143 {

    public static String wordsInSentence(String sentence) {
        StringBuilder newLst = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            int flg = 0;
            if (word.length() == 1) {
                flg = 1;
            }
            for (int i = 2; i < word.length(); i++) {
                if (word.length() % i == 0) {
                    flg = 1;
                }
            }
            if (flg == 0 || word.length() == 2) {
                if (newLst.length() > 0) {
                    newLst.append(" ");
                }
                newLst.append(word);
            }
        }
        return newLst.toString();
    }

}