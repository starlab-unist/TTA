// Source Code
function get_max_triples(n) {
    let A = [];
    for (let i = 1; i <= n; i++) {
        A.push(i * i - i + 1);
    }
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
function countDivisibleTriples(n) {
    let sequence = [];
    for (let x = 1; x <= n; x++) {
        sequence.push(x * x - x + 1);
    }
    
    let resultCount = 0;
    
    let indexI = 0;
    while (indexI < n) {
        let indexJ = indexI + 1;
        while (indexJ < n) {
            let indexK = indexJ + 1;
            while (indexK < n) {
                if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 === 0) {
                    resultCount++;
                }
                indexK++;
            }
            indexJ++;
        }
        indexI++;
    }
    
    return resultCount;
}

// Test Cases
describe('get_max_triples vs countDivisibleTriples equivalence tests', () => {
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
        it(`should return the same result for n = ${testCase}`, () => {
            expect(get_max_triples(testCase)).toBe(countDivisibleTriples(testCase));
        });
    });
});