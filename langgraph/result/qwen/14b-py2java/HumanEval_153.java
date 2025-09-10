public class HumanEval_153 {
    public static String Strongest_Extension(String class_name, String[] extensions) {
        String strong = extensions[0];
        int my_val = countUpperLowerDifference(extensions[0]);
        
        for (String s : extensions) {
            int val = countUpperLowerDifference(s);
            if (val > my_val) {
                strong = s;
                my_val = val;
            }
        }

        return class_name + "." + strong;
    }

    private static int countUpperLowerDifference(String extension) {
        int upperCount = 0;
        int lowerCount = 0;
        
        for (char c : extension.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    upperCount++;
                } else if (Character.isLowerCase(c)) {
                    lowerCount++;
                }
            }
        }
        
        return upperCount - lowerCount;
    }
}