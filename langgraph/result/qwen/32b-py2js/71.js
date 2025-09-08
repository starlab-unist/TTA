function triangleArea(a, b, c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1;
    }
    const s = (a + b + c) / 2;
    let area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    area = Math.round(area * 100) / 100;
    return area;
}