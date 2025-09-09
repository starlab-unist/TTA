public class HumanEval_156 {

    public static String intToMiniRoman(int number) {
        int[] num = {1, 4, 5, 9, 10, 40, 50, 90,
                100, 400, 500, 900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL",
                "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 12;
        StringBuilder res = new StringBuilder();
        while (number > 0) {
            int div = number / num[i];
            number %= num[i];
            while (div > 0) {
                res.append(sym[i]);
                div--;
            }
            i--;
        }
        return res.toString().toLowerCase();
    }

}