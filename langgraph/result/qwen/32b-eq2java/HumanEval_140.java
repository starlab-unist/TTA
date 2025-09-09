public class HumanEval_140 {
    public String adjustWhitespace(String inputString) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int begin = 0, finish = 0;
        while (index < inputString.length()) {
            if (inputString.charAt(index) == ' ') {
                finish++;
            } else {
                int spaceCount = finish - begin;
                if (spaceCount > 2) {
                    result.append("-").append(inputString.charAt(index));
                } else if (spaceCount > 0) {
                    for (int i = 0; i < spaceCount; i++) {
                        result.append("_");
                    }
                    result.append(inputString.charAt(index));
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
}