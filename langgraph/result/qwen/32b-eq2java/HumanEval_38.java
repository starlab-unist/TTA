public class HumanEval_38 {

    /**
     * Returns encoded string by cycling groups of three characters.
     */
    public static String transformCyclicString(String inputString) {
        // Divide the string into chunks of three characters
        StringBuilder[] chunks = new StringBuilder[(inputString.length() + 2) / 3];
        for (int i = 0; i < inputString.length(); i += 3) {
            chunks[i / 3] = new StringBuilder(inputString.substring(i, Math.min(i + 3, inputString.length())));
        }

        // Rotate each chunk if it contains exactly three characters
        for (int i = 0; i < chunks.length; i++) {
            if (chunks[i].length() == 3) {
                char firstChar = chunks[i].charAt(0);
                chunks[i].deleteCharAt(0);
                chunks[i].append(firstChar);
            }
        }

        // Join all chunks back into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder chunk : chunks) {
            result.append(chunk);
        }
        return result.toString();
    }

    public static String reverseCyclicTransformation(String encodedString) {
        // Apply the transformation twice to decode the string
        return transformCyclicString(transformCyclicString(encodedString));
    }
}