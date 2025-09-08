// Source Code
function circularShift(x, shift) {
    let s = x.toString();
    if (shift > s.length) {
        return s.split('').reverse().join('');
    } else {
        return s.slice(-shift) + s.slice(0, -shift);
    }
}

// Transformed Code (Semantically Equivalent)
function rotateString(x, shift) {
    let s = String(x);
    let length = s.length;
    
    if (shift >= length) {
        return s.split('').reverse().join('');
    } else {
        let splitPoint = length - shift;
        let rotatedPart = s.slice(splitPoint);
        let remainingPart = s.slice(0, splitPoint);
        return rotatedPart + remainingPart;
    }
}

// Test Cases
describe('circularShift vs rotateString equivalence tests', () => {
    const testCases = [
        [12345, 2],       // Normal circular shift
        [12345, 5],       // Full rotation, should return the same number
        [12345, 6],       // Shift greater than length, should reverse
        [987654321, 3],    // Normal circular shift with a larger number
        [987654321, 9],    // Full rotation, should return the same number
        [987654321, 10],   // Shift greater than length, should reverse
        [11111, 2],       // All digits same, shift within bounds
        [11111, 6],       // All digits same, shift out of bounds
        [0, 1],           // Single digit number, shift within bounds
        [0, 0]            // Single digit number, no shift
    ];

    test.each(testCases)('Input: x=%d, shift=%d', (x, shift) => {
        expect(circularShift(x, shift)).toBe(rotateString(x, shift));
    });
});