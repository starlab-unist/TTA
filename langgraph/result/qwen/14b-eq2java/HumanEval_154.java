public class HumanEval_154 {
    public static boolean verifyCyclicPattern(String sequence, String pattern) {
        int patternLength = pattern.length();
        String doubledPattern = pattern + pattern;
        int index = 0;
        
        while (index <= sequence.length() - patternLength) {
            int subIndex = 0;
            while (subIndex <= patternLength) {
                if (sequence.substring(index, index + patternLength).equals(doubledPattern.substring(subIndex, subIndex + patternLength))) {
                    return true;
                }
                subIndex += 1;
            }
            index += 1;
        }
        
        return false;
    }
}