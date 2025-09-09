import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {

    public Map<String, Integer> generateFrequencyMap(String inputString) {
        Map<String, Integer> frequencyDict = new HashMap<>();
        String[] wordList = inputString.split("\\s+");
        int maxCount = 0;

        for (String word : wordList) {
            int currentCount = 0;
            for (String w : wordList) {
                if (w.equals(word)) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount && !word.isEmpty()) {
                maxCount = currentCount;
            }
        }

        if (maxCount > 0) {
            for (String word : wordList) {
                if (wordList.length > 0 && wordList[0].equals(word)) {
                    int count = 0;
                    for (String w : wordList) {
                        if (w.equals(word)) {
                            count++;
                        }
                    }
                    if (count == maxCount) {
                        frequencyDict.put(word, maxCount);
                    }
                }
            }
        }

        return frequencyDict;
    }
}