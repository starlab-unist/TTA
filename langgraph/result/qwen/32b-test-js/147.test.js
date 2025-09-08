// Source Code
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

// Transformed Code (Semantically Equivalent)
function countDivisibleTriples(limit) {
    const sequence = Array.from({ length: limit }, (_, x) => x * x - x + 1);
    let resultCount = 0;
    
    let indexI = 0;
    while (indexI < limit) {
        let indexJ = indexI + 1;
        while (indexJ < limit) {
            let indexK = indexJ + 1;
            while (indexK < limit) {
                if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 === 0) {
                    resultCount += 1;
                }
                indexK += 1;
            }
            indexJ += 1;
        }
        indexI += 1;
    }
    
    return resultCount;
}

// Test Cases
describe('getMaxTriples vs countDivisibleTriples equivalence tests', () => {
    const testCases = [
        1,  // No triples possible
        2,  // No triples possible
        3,  // One triple (1, 3, 7)
        4,  // Two triples (1, 7, 19), (3, 7, 13)
        5,  // Four triples (1, 7, 31), (1, 13, 21), (3, 7, 31), (3, 13, 19)
        6,  // Six triples
        7,  // Ten triples
        8,  // Fourteen triples
        9,  // Twenty-one triples
        10  // Thirty-one triples
    ];

    testCases.forEach((testCase, index) => {
        test(`test_${index}`, () => {
            expect(getMaxTriples(testCase)).toBe(countDivisibleTriples(testCase));
        });
    });
});