public class HumanEval_84 {
    public String convertToBinaryString(int number) {
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }
        String binaryRepresentation = Integer.toBinaryString(digitSum);
        return binaryRepresentation;
    }
}