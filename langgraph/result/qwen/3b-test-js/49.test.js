// Source Code
function modp(n, p) {
    let ret = 1;
    for (let i = 0; i < n; i++) {
        ret = (2 * ret) % p;
    }
    return ret;
}

// Transformed Code (Semantically Equivalent)
function modpTransformed(n, p) {
    let ret = 1;
    let i = 0;
    while (i < n) {
        ret = (2 * ret) % p;
        i++;
    }
    return ret;
}

// Test Cases
describe('modp vs modpTransformed equivalence tests', () => {
    const testCases = [
        [0, 5],       // n=0, p=5
        [1, 3],       // n=1, p=3
        [2, 7],       // n=2, p=7
        [3, 4],       // n=3, p=4
        [5, 10],      // n=5, p=10
        [10, 13],     // n=10, p=13
        [20, 17],     // n=20, p=17
        [31, 31],     // n=31, p=31
        [50, 61],     // n=50, p=61
        [100, 97]     // n=100, p=97
    ];

    test.each(testCases)('Input: n=%d, p=%d', (n, p) => {
        expect(modp(n, p)).toBe(modpTransformed(n, p));
    });
});