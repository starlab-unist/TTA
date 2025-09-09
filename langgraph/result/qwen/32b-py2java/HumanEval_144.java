class HumanEval_144 {
    public static boolean simplify(String x, String n) {
        String[] fraction1 = x.split("/");
        String[] fraction2 = n.split("/");
        int numerator = Integer.parseInt(fraction1[0]) * Integer.parseInt(fraction2[0]);
        int denom = Integer.parseInt(fraction1[1]) * Integer.parseInt(fraction2[1]);
        return (numerator / (double) denom == Math.floor(numerator / (double) denom));
    }
}