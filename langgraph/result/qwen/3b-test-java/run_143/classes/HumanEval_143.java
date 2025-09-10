public class HumanEval_143 {
    public static String filterUniqueLengthWords(String phrase) {
        StringBuilder result = new StringBuilder();
        String[] terms = phrase.split("\\s+");
        
        for (String term : terms) {
            boolean flag = false;
            if (term.length() == 1) {
                flag = true;
            }
            int divisor = 2;
            while (divisor < term.length()) {
                if (term.length() % divisor == 0) {
                    flag = true;
                    break;
                }
                divisor++;
            }
            if (!flag || term.length() == 2) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(term);
            }
        }
        
        return result.toString();
    }
}