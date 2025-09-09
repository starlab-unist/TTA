public class HumanEval_137 {
    public static Object compareOne(Object a, Object b) {
        String tempA = a.toString();
        String tempB = b.toString();

        if (tempA.contains(",")) tempA = tempA.replace(',', '.');
        if (tempB.contains(",")) tempB = tempB.replace(',', '.');

        double numA = Double.parseDouble(tempA);
        double numB = Double.parseDouble(tempB);

        if (numA == numB) return null;
        return numA > numB ? a : b;
    }
}