function triangleArea(a, b, c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1; 
    }
    let s = (a + b + c) / 2;
    let area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    area = parseFloat(area.toFixed(2));
    return area;
}