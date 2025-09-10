public class HumanEval_101 {

    public static String[] processText(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new String[0];
        }

        StringBuilder processedChars = new StringBuilder();

        int index = 0;
        while (index < inputString.length()) {
            char charAt = inputString.charAt(index);
            if (charAt == ',') {
                processedChars.append(' ');
            } else {
                processedChars.append(charAt);
            }
            index++;
        }

        String processedString = processedChars.toString();
        return processedString.split("\\s+");
    }
}