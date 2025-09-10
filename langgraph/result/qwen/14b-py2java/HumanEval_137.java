public class HumanEval_137 {
    public static Object compareOne(Object a, Object b) {
        String tempA = a.toString();
        String tempB = b.toString();
        
        if (tempA instanceof String) tempA = tempA.replace(',', '.');
        if (tempB instanceof String) tempB = tempB.replace(',', '.');
        
        double numA = Double.parseDouble(tempA);
        double numB = Double.parseDouble(tempB);
        
        if (numA == numB) return null;
        return numA > numB ? a : b;
    }
}