public class HumanEval_153 {
    public static String Strongest_Extension(String className, String[] extensions) {
        String strong = extensions[0];
        int myVal = countUpper(extensions[0]) - countLower(extensions[0]);

        for (String s : extensions) {
            int val = countUpper(s) - countLower(s);
            if (val > myVal) {
                strong = s;
                myVal = val;
            }
        }

        return className + "." + strong;
    }

    private static int countUpper(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    private static int countLower(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }
}