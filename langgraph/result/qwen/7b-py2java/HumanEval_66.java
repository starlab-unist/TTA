public class HumanEval_66 {
    public static int digitSum(String s) {
        if (s.isEmpty()) return 0;
        return s.chars()
                 .filter(Character::isUpperCase)
                 .mapToObj(c -> (char) c)
                 .mapToInt(c -> (int) c)
                 .sum();
    }
}