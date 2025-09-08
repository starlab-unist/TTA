function computeTriangleArea(a, b, c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1;
    }
    
    const s = (a + b + c) / 2;
    const area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    const roundedArea = Math.round(area * 100) / 100;
    
    return roundedArea;
}

// function name: computeTriangleArea
// parameter names: a -> side1, b -> side2, c -> side3
// variable name: s -> semiPerimeter, area -> computedArea
// introduced an intermediate variable roundedArea for clarity