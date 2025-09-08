function computeTriangleArea(side1, side2, side3) {
    if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
        return -1;
    }
    
    const semiPerimeter = (side1 + side2 + side3) / 2;
    const computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    const roundedArea = Math.round(computedArea * 100) / 100;
    
    return roundedArea;
}