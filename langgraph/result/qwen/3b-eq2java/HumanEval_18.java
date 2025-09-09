public class HumanEval_18 {

    public static int countOccurrences(String mainStr, String subStr) {
        int occurrenceCount = 0;
        int index = 0;

        while (index <= mainStr.length() - subStr.length()) {
            if (mainStr.substring(index, index + subStr.length()).equals(subStr)) {
                occurrenceCount++;
            }
            index++;
        }

        return occurrenceCount;
    }
}