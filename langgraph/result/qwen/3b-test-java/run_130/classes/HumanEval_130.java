public class HumanEval_130 {

    public static List<Double> generateCustomSequence(int length) {
        if (length == 0) {
            return Arrays.asList(1.0);
        }

        List<Double> sequence = new ArrayList<>();
        sequence.add(1.0);
        sequence.add(3.0);

        int index = 2;

        while (index <= length) {
            if (index % 2 == 0) {
                sequence.add(index / 2 + 1.0);
            } else {
                sequence.add(sequence.get(index - 1) + sequence.get(index - 2) + (index + 3) / 2.0);
            }
            index++;
        }

        return sequence;
    }
}