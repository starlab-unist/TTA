public class HumanEval_158 {

    public static String determineLongestUniqueCharString(String[] words) {
        // Define a custom comparator to sort words based on the number of unique characters and lexicographical order
        java.util.Comparator<String> customSortKey = (word1, word2) -> {
            int uniqueCount1 = word1.chars().distinct().count();
            int uniqueCount2 = word2.chars().distinct().count();
            
            if (uniqueCount1 != uniqueCount2) {
                return Integer.compare(uniqueCount2, uniqueCount1); // Descending order of unique characters
            } else {
                return word1.compareTo(word2); // Lexicographical order
            }
        };

        // Sort the words using the custom comparator
        java.util.Arrays.sort(words, customSortKey);

        // Return the first word in the sorted list, which will be the longest with unique characters
        return words[0];
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date"};
        System.out.println(determineLongestUniqueCharString(words)); // Output: "banana"
    }
}