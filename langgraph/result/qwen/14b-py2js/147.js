function getMaxTriples(n) {
    const A = Array.from({ length: n }, (_, i) => i * i - i + 1);
    let ans = [];
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                if ((A[i] + A[j] + A[k]) % 3 === 0) {
                    ans.push([A[i], A[j], A[k]]);
                }
            }
        }
    }
    return ans.length;
}