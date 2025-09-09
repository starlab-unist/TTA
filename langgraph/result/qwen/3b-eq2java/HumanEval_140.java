public class HumanEval_140 {
    public static String adjustWhitespace(String inputString) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int begin = 0, finish = 0;
        while (index < inputString.length()) {
            if (inputString.charAt(index) == ' ') {
                finish++;
            } else {
                int spaceCount = finish - begin;
                if (spaceCount > 2) {
                    result.append("-");
                } else if (spaceCount > 0) {
                    result.append("_".repeat(spaceCount));
                } else {
                    result.append(inputString.charAt(index));
                }
                begin = index + 1;
                finish = index + 1;
            }
            index++;
        }
        int finalSpaceCount = finish - begin;
        if (finalSpaceCount > 2) {
            result.append("-");
        } else if (finalSpaceCount > 0) {
            result.append("_");
        }
        return result.toString();
    }

    // method name: fixSpaces -> adjustWhitespace
    // parameter name: text -> inputString
    // variable name: new_text -> result, i -> index, start -> begin, end -> finish
    // replaced inline conditions with a separate variable for space count (spaceCount)
    // maintained the same logic and output structure
}