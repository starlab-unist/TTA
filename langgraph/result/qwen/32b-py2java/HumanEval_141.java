public class HumanEval_141 {
    public String fileNameCheck(String fileName) {
        String[] suf = {"txt", "exe", "dll"};
        String[] lst = fileName.split("\\.");
        if (lst.length != 2) {
            return "No";
        }
        boolean isValidSuffix = false;
        for (String suffix : suf) {
            if (lst[1].equals(suffix)) {
                isValidSuffix = true;
                break;
            }
        }
        if (!isValidSuffix) {
            return "No";
        }
        if (lst[0].length() == 0) {
            return "No";
        }
        if (!Character.isLetter(lst[0].charAt(0))) {
            return "No";
        }
        int digitCount = 0;
        for (char c : lst[0].toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        if (digitCount > 3) {
            return "No";
        }
        return "Yes";
    }
}