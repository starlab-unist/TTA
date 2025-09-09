public class HumanEval_125 {
    public static String[] splitWords(String txt) {
        if (txt.contains(" ")) {
            return txt.split(" ");
        } else if (txt.contains(",")) {
            return txt.replace(',', ' ').split(" ");
        } else {
            int count = 0;
            for (char i : txt.toCharArray()) {
                if (Character.isLowerCase(i) && (i % 2 == 0)) {
                    count++;
                }
            }
            return new String[count];
        }
    }
}