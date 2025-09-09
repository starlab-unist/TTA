public class HumanEval_40 {
    public static boolean checkForZeroSumTriplets(int[] numbers) {
        int length = numbers.length;
        int indexI = 0;
        
        while (indexI < length) {
            int indexJ = indexI + 1;
            while (indexJ < length) {
                int indexK = indexJ + 1;
                while (indexK < length) {
                    if (numbers[indexI] + numbers[indexJ] + numbers[indexK] == 0) {
                        return true;
                    }
                    indexK++;
                }
                indexJ++;
            }
            indexI++;
        }
        
        return false;
    }
}