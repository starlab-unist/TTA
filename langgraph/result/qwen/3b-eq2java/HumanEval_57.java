public class HumanEval_57 {

    public static boolean checkMonotonicSequence(List<Integer> sequence) {
        List<Integer> ascending = new ArrayList<>(sequence);
        List<Integer> descending = new ArrayList<>(sequence);

        Collections.sort(ascending);
        Collections.sort(descending, Collections.reverseOrder());

        return sequence.equals(ascending) || sequence.equals(descending);
    }
}