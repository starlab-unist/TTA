class HumanEval_144 {
    public static boolean checkFractionSimplification(String fraction1, String fraction2) {
        String[] parts1 = fraction1.split("/");
        String[] parts2 = fraction2.split("/");
        int num1 = Integer.parseInt(parts1[0]);
        int denom1 = Integer.parseInt(parts1[1]);
        int num2 = Integer.parseInt(parts2[0]);
        int denom2 = Integer.parseInt(parts2[1]);
        int resultNumerator = num1 * num2;
        int resultDenominator = denom1 * denom2;
        return resultNumerator % resultDenominator == 0;
    }
}