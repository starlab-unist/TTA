public class HumanEval_147 {

    public static int countDivisibleTriples(int limit) {
        int[] sequence = new int[limit];
        for (int i = 1; i <= limit; i++) {
            sequence[i - 1] = i * i - i + 1;
        }

        int resultCount = 0;

        int indexI = 0;
        while (indexI < limit) {
            int indexJ = indexI + 1;
            while (indexJ < limit) {
                int indexK = indexJ + 1;
                while (indexK < limit) {
                    if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 == 0) {
                        resultCount++;
                    }
                    indexK++;
                }
                indexJ++;
            }
            indexI++;
        }

        return resultCount;
    }
}