public class HumanEval_71 {
    public double computeTriangleArea(double side1, double side2, double side3) {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return -1;
        }
        
        double semiPerimeter = (side1 + side2 + side3) / 2;
        double computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        double roundedArea = Math.round(computedArea * 100.0) / 100.0;
        
        return roundedArea;
    }
}