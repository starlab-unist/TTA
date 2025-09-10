public class HumanEval_69 {
    public static int findMaxFrequencyIndex(int[] numbers) {
        int maxValue = Arrays.stream(numbers).max().orElse(0);
        int[] frequencyArray = new int[maxValue + 1];
        
        for (int number : numbers) {
            frequencyArray[number]++;
        }

        int result = -1;
        int index = 1;
        while (index < frequencyArray.length) {
            if (frequencyArray[index] >= index) {
                result = index;
            }
            index++;
        }

        return result;
    }
}