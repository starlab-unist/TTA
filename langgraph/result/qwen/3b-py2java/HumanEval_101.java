public class HumanEval_101 {

    public static String[] wordsString(String s) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }

        StringBuilder sList = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (letter == ',') {
                sList.append(' ');
            } else {
                sList.append(letter);
            }
        }

        sList = new String(sList);
        return sList.split("\\s+");
    }
}