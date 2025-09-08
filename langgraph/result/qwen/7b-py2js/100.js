function makeAPile(n) {
    return Array.from({ length: n }, (_, i) => n + 2 * i);
}