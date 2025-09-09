public class HumanEval_38 {

    /**
     * Returns encoded string by cycling groups of three characters.
     */
    public static String transformCyclicString(String inputString) {
        // Divide the string into chunks of three characters
        int length = inputString.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i += 3) {
            String chunk = inputString.substring(i, Math.min(length, i + 3));
            
            // Rotate each chunk if it contains exactly three characters
            if (chunk.length() == 3) {
                result.append(chunk.substring(1)).append(chunk.charAt(0));
            } else {
                result.append(chunk);
            }
        }
        
        return result.toString();
    }

    /**
     * Decodes the string that was encoded using the transformCyclicString method.
     */
    public static String reverseCyclicTransformation(String encodedString) {
        // Apply the transformation twice to decode the string
        return transformCyclicString(transformCyclicString(encodedString));
    }
}