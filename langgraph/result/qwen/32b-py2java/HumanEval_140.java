public class HumanEval_140 {
    public static String fixSpaces(String text) {
        StringBuilder newText = new StringBuilder();
        int i = 0;
        int start = 0, end = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end += 1;
            } else {
                if (end - start > 2) {
                    newText.append("-").append(text.charAt(i));
                } else if (end - start > 0) {
                    for (int j = 0; j < end - start; j++) {
                        newText.append("_");
                    }
                    newText.append(text.charAt(i));
                } else {
                    newText.append(text.charAt(i));
                }
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        if (end - start > 2) {
            newText.append("-");
        } else if (end - start > 0) {
            newText.append("_");
        }
        return newText.toString();
    }
}