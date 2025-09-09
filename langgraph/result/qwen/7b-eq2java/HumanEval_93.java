public class HumanEval_93 {
    public static String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder vowelMappingBuilder = new StringBuilder();
        for (char c : vowelSet.toCharArray()) {
            vowelMappingBuilder.append((char) (c + 2));
        }
        String vowelMapping = vowelMappingBuilder.toString();

        StringBuilder resultBuilder = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            int index = vowelSet.indexOf(c);
            if (index != -1) {
                resultBuilder.append(vowelMapping.charAt(index));
            } else {
                resultBuilder.append(c);
            }
        }

        return resultBuilder.toString().toUpperCase().toLowerCase();
    }
}