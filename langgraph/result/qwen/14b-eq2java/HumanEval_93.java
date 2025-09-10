public class HumanEval_93 {
    public static String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder vowelMapping = new StringBuilder();
        for (char c : vowelSet.toCharArray()) {
            vowelMapping.append(c).append((char)(c + 2));
        }
        
        String modifiedText = swapCase(inputText);
        StringBuilder result = new StringBuilder();
        
        for (char charInText : modifiedText.toCharArray()) {
            int index = vowelMapping.indexOf(charInText);
            if (index != -1 && index % 2 == 0) {
                result.append(vowelMapping.charAt(index + 1));
            } else {
                result.append(charInText);
            }
        }
        
        return result.toString();
    }

    private static String swapCase(String text) {
        StringBuilder swappedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                swappedText.append(Character.toLowerCase(c));
            } else {
                swappedText.append(Character.toUpperCase(c));
            }
        }
        return swappedText.toString();
    }
}