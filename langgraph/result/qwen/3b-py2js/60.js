function sumToN(n) {
    return Array.from({ length: n + 1 }, (_, i) => i).reduce((acc, curr) => acc + curr, 0);
}