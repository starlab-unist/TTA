function computeTriangleArea(a, b, c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1;
    }

    const semiPerimeter = (a + b + c) / 2;
    const computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    const roundedArea = parseFloat(computedArea.toFixed(2));

    return roundedArea;
}