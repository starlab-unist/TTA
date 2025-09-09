public class HumanEval_153 {
    public static String Strongest_Extension(String class_name, List<String> extensions) {
        String strong = extensions.get(0);
        int my_val = countUppercaseLetters(strong) - countLowercaseLetters(strong);

        for (String s : extensions) {
            int val = countUppercaseLetters(s) - countLowercaseLetters(s);
            if (val > my_val) {
                strong = s;
                my_val = val;
            }
        }

        String ans = class_name + "." + strong;
        return ans;
    }

    private static int countUppercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    private static int countLowercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }
}