public class HumanEval_140 {
    public static String adjust_whitespace(String input_string) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int begin = 0, finish = 0;
        while (index < input_string.length()) {
            if (input_string.charAt(index) == ' ') {
                finish += 1;
            } else {
                int space_count = finish - begin;
                if (space_count > 2) {
                    result.append("-").append(input_string.charAt(index));
                } else if (space_count > 0) {
                    for (int i = 0; i < space_count; i++) {
                        result.append("_");
                    }
                    result.append(input_string.charAt(index));
                } else {
                    result.append(input_string.charAt(index));
                }
                begin = index + 1;
                finish = index + 1;
            }
            index += 1;
        }
        int final_space_count = finish - begin;
        if (final_space_count > 2) {
            result.append("-");
        } else if (final_space_count > 0) {
            result.append("_");
        }
        return result.toString();
    }
}