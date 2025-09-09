public class HumanEval_64 {
    public static int tallyVowels(String inputString) {
        String vowelSet = "aeiouAEIOU";
        int vowelCounter = 0;

        for (char character : inputString.toCharArray()) {
            if (vowelSet.indexOf(character) != -1) {
                vowelCounter++;
            }
        }

        if (inputString.endsWith("y") || inputString.endsWith("Y")) {
            vowelCounter++;
        }

        return vowelCounter;
    }
}