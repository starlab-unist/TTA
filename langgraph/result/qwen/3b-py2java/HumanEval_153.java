public class HumanEval_153 {

    public static String StrongestExtension(String className, String[] extensions) {
        String strong = extensions[0];
        int myVal = countUppercaseLetters(extensions[0]) - countLowercaseLetters(extensions[0]);

        for (String s : extensions) {
            int val = countUppercaseLetters(s) - countLowercaseLetters(s);
            if (val > myVal) {
                strong = s;
                myVal = val;
            }
        }

        return className + "." + strong;
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