public class HumanEval_18 {

    public static int howManyTimes(String string, String substring) {
        int times = 0;
        int index = 0;

        while ((index = string.indexOf(substring, index)) != -1) {
            times++;
            index++; // Move one character forward to allow overlapping matches
        }

        return times;
    }
}