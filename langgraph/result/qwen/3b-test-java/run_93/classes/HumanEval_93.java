public class HumanEval_93 {

    public static String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        String vowelMapping = new String();
        for (int i = 0; i < vowelSet.length(); i++) {
            char originalChar = vowelSet.charAt(i);
            char newChar = (char) (originalChar + 2);
            vowelMapping += originalChar + "=" + newChar;
        }
        String modifiedText = inputText.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (char charInText : modifiedText.toCharArray()) {
            if (vowelMapping.indexOf("=" + charInText) != -1) {
                result.append(vowelMapping.split("=")[vowelMapping.indexOf("=" + charInText) + 1]);
            } else {
                result.append(charInText);
            }
        }
        return result.toString();
    }
}