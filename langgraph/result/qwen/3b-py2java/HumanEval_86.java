public class HumanEval_86 {

    public static String anti_shuffle(String s) {
        return String.join(" ", 
                s.split(" ")
                        .map(str -> String.join("", 
                                str.chars()
                                        .sorted()
                                        .mapToObj(c -> String.valueOf((char) c))
                                        .collect(Collectors.toList()))));
    }
}