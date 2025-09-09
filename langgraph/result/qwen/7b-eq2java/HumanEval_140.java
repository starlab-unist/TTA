public class HumanEval_140 {
    public static String fixSpaces(String text) {
        StringBuilder new_text = new StringBuilder();
        int i = 0;
        int start = 0, end = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end++;
            } else {
                int spaceCount = end - start;
                if (spaceCount > 2) {
                    new_text.append('-').append(text.charAt(i));
                } else if (spaceCount > 0) {
                    new_text.append('_'.repeat(spaceCount)).append(text.charAt(i));
                } else {
                    new_text.append(text.charAt(i));
                }
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        int finalSpaceCount = end - start;
        if (finalSpaceCount > 2) {
            new_text.append('-');
        } else if (finalSpaceCount > 0) {
            new_text.append('_'.repeat(finalSpaceCount));
        }
        return new_text.toString();
    }
}