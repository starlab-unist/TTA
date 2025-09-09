public class HumanEval_69 {
    public int findMaxFrequencyIndex(int[] numbers) {
        int maxValue = 0;
        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        
        int[] frequencyArray = new int[maxValue + 1];
        
        for (int number : numbers) {
            frequencyArray[number] += 1;
        }

        int result = -1;
        int index = 1;
        while (index < frequencyArray.length) {
            if (frequencyArray[index] >= index) {
                result = index;
            }
            index += 1;
        }

        return result;
    }
}