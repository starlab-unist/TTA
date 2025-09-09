public class HumanEval_62 {
    public static List<Double> derivative(List<Double> xs) {
        return IntStream.range(1, xs.size())
                .mapToObj(i -> i * xs.get(i))
                .collect(Collectors.toList());
    }
}