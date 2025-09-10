public class HumanEval_54 {

    public static boolean compareCharacterSets(String s0, String s1) {
        Set<Character> setOfCharsOne = new HashSet<>();
        Set<Character> setOfCharsTwo = new HashSet<>();

        for (char c : s0.toCharArray()) {
            setOfCharsOne.add(c);
        }

        for (char c : s1.toCharArray()) {
            setOfCharsTwo.add(c);
        }

        return setOfCharsOne.equals(setOfCharsTwo);
    }
}