public class HumanEval_38 {
    public static String transformCyclicString(String inputString) {
        // Divide the string into chunks of three characters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputString.length(); i += 3) {
            String chunk = inputString.substring(i, Math.min(i + 3, inputString.length()));
            
            // Rotate each chunk if it contains exactly three characters
            if (chunk.length() == 3) {
                chunk = chunk.substring(1) + chunk.charAt(0);
            }
            
            // Append the chunk to the result
            result.append(chunk);
        }
        
        return result.toString();
    }

    public static String reverseCyclicTransformation(String encodedString) {
        // Apply the transformation twice to decode the string
        return transformCyclicString(transformCyclicString(encodedString));
    }
}