// Source Code
function intersection(interval1, interval2) {
    function isPrime(num) {
        if (num === 1 || num === 0) return false;
        if (num === 2) return true;
        for (let i = 2; i < num; i++) {
            if (num % i === 0) return false;
        }
        return true;
    }

    let l = Math.max(interval1[0], interval2[0]);
    let r = Math.min(interval1[1], interval2[1]);
    let length = r - l;

    if (length > 0 && isPrime(length)) {
        return "YES";
    }
    return "NO";
}

// Transformed Code (Semantically Equivalent)
function checkIntervalForPrimeLength(range1, range2) {
    function primeCheck(number) {
        if (number === 0 || number === 1) return false;
        if (number === 2) return true;
        for (let divisor = 2; divisor < number; divisor++) {
            if (number % divisor === 0) return false;
        }
        return true;
    }

    const [start, end] = range1[0] < range2[0] ? [range1, range2] : [range2, range1];
    let l = Math.max(start[0], end[0]);
    let r = Math.min(start[1], end[1]);
    let length = r - l;

    if (length > 0 && primeCheck(length)) {
        return "YES";
    }
    return "NO";
}

// Test Cases
describe('Function Equivalence Tests', () => {
    const testCases = [
        [[1, 5], [3, 7]],   // Overlapping interval with prime length 2
        [[10, 20], [15, 25]], // Overlapping interval with non-prime length 5
        [[5, 5], [5, 5]],     // No overlap
        [[2, 3], [3, 4]],     // No overlap
        [[0, 1], [1, 2]],     // No overlap
        [[1, 10], [5, 6]],    // Overlapping interval with prime length 1
        [[1, 11], [5, 7]],    // Overlapping interval with non-prime length 2
        [[4, 9], [8, 13]],    // Overlapping interval with prime length 1
        [[1, 20], [5, 15]],   // Overlapping interval with non-prime length 10
        [[7, 11], [9, 13]]    // Overlapping interval with prime length 2
    ];

    testCases.forEach(([interval1, interval2], index) => {
        it(`Test Case ${index}`, () => {
            expect(intersection(interval1, interval2)).toBe(checkIntervalForPrimeLength(interval1, interval2));
        });
    });
});