public class HumanEval_144 {

    public static boolean checkFractionSimplification(String fraction1, String fraction2) {
        String[] parts1 = fraction1.split("/");
        String[] parts2 = fraction2.split("/");

        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1]);
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1]);

        int numerator = a * c;
        int denominator = b * d;

        return numerator % denominator == 0;
    }
}