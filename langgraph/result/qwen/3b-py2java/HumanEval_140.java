public class HumanEval_140 {

    public static String fixSpaces(String text) {
        StringBuilder new_text = new StringBuilder();
        int i = 0;
        int start = 0;
        int end = 0;

        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end++;
            } else {
                if (end - start > 2) {
                    new_text.append("-");
                } else if (end - start > 0) {
                    new_text.append("_".repeat(end - start));
                } else {
                    new_text.append(text.charAt(i));
                }
                start = end;
                end = i + 1;
            }
            i++;
        }

        if (end - start > 2) {
            new_text.append("-");
        } else if (end - start > 0) {
            new_text.append("_");
        }

        return new_text.toString();
    }
}