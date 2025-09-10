import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {

    public static Map<String, Integer> generateFrequencyMap(String inputString) {
        Map<String, Integer> frequencyDict = new HashMap<>();
        String[] wordList = inputString.split("\\s+");
        int maxCount = 0;

        for (String word : wordList) {
            int currentCount = wordList.length - wordList.replaceAll("\\b" + word + "\\b", "").length();
            if (currentCount > maxCount && !word.isEmpty()) {
                maxCount = currentCount;
            }
        }

        if (maxCount > 0) {
            for (String word : wordList) {
                if (wordList.length - wordList.replaceAll("\\b" + word + "\\b", "").length() == maxCount) {
                    frequencyDict.put(word, maxCount);
                }
            }
        }

        return frequencyDict;
    }
}