public class HumanEval_51 {

    public static String stripVowels(String inputString) {
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        List<Character> result = new ArrayList<>();
        int index = 0;

        while (index < inputString.length()) {
            char charAtIndex = inputString.charAt(index);
            if (!vowels.contains(charAtIndex)) {
                result.add(charAtIndex);
            }
            index++;
        }

        return new String(result.toArray(new Character[0]));
    }
}