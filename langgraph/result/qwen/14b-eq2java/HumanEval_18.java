public class HumanEval_18 {
    public static int count_occurrences(String main_str, String sub_str) {
        int occurrence_count = 0;
        int index = 0;

        while (index <= main_str.length() - sub_str.length()) {
            if (main_str.substring(index, index + sub_str.length()).equals(sub_str)) {
                occurrence_count += 1;
            }
            index += 1;
        }

        return occurrence_count;
    }
}