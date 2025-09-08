// Source Code
function isPrime(num) {
    if (num === 1 || num === 0) {
        return false;
    }
    if (num === 2) {
        return true;
    }
    for (let i = 2; i < num; i++) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

function intersection(interval1, interval2) {
    let l = Math.max(interval1[0], interval2[0]);
    let r = Math.min(interval1[1], interval2[1]);
    let length = r - l;
    if (length > 0 && isPrime(length)) {
        return "YES";
    }
    return "NO";
}

// Transformed Code (Semantically Equivalent)
function checkIntervalForPrimeLength(interval1, interval2) {
    function primeCheck(number) {
        if (number === 0 || number === 1) {
            return false;
        }
        if (number === 2) {
            return true;
        }
        for (let i = 2; i < number; i++) {
            if (number % i === 0) {
                return false;
            }
        }
        return true;
    }

    let l = Math.max(interval1[0], interval2[0]);
    let r = Math.min(interval1[1], interval2[1]);
    let length = r - l;
    if (length > 0 && primeCheck(length)) {
        return "YES";
    }
    return "NO";
}

// Jest Test Cases
describe('Intersection and CheckIntervalForPrimeLength', () => {
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
        it(`Test case ${index}`, () => {
            expect(intersection(interval1, interval2)).toBe(checkIntervalForPrimeLength(interval1, interval2));
        });
    });
});