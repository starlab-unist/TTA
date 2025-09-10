public class HumanEval_38 {

    public static String transformCyclicString(String inputString) {
        // Divide the string into chunks of three characters
        StringBuilder chunks = new StringBuilder();
        for (int i = 0; i < inputString.length(); i += 3) {
            chunks.append(inputString.substring(i, Math.min(i + 3, inputString.length())));
        }
        
        // Rotate each chunk if it contains exactly three characters
        StringBuilder rotatedChunks = new StringBuilder();
        for (int i = 0; i < chunks.length(); i++) {
            if (chunks.charAt(i) != '\0') {
                char firstChar = chunks.charAt(i);
                chunks.setCharAt(i, chunks.charAt((i + 1) % chunks.length()));
                chunks.setCharAt((i + 1) % chunks.length(), firstChar);
            }
        }
        
        // Join all chunks back into a single string
        return chunks.toString();
    }

    public static String reverseCyclicTransformation(String encodedString) {
        // Apply the transformation twice to decode the string
        return transformCyclicString(transformCyclicString(encodedString));
    }
}