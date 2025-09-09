public class HumanEval_30 {

    public static List<Integer> getPositive(List<Integer> l) {
        return l.stream().filter(e -> e > 0).collect(Collectors.toList());
    }
}