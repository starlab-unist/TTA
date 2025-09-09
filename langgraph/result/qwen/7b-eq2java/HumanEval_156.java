public class HumanEval_156 {
    public static String convertIntegerToMinimalRoman(int number) {
        int[] numeralValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = numeralValues.length - 1;
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int quotient = number / numeralValues[index];
            number %= numeralValues[index];
            while (quotient > 0) {
                result.append(romanSymbols[index]);
                quotient--;
            }
            index--;
        }
        return result.toString().toLowerCase();
    }
}