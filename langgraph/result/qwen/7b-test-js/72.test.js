// Source Code
function willItFly(q, w) {
    if (q.reduce((a, b) => a + b, 0) > w) {
        return false;
    }

    let i = 0, j = q.length - 1;
    while (i < j) {
        if (q[i] !== q[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function canItTakeOff(weights, maxWeight) {
    let totalWeight = weights.reduce((acc, weight) => acc + weight, 0);

    if (totalWeight > maxWeight) {
        return false;
    }

    let start = 0;
    let end = weights.length - 1;
    while (start < end) {
        if (weights[start] !== weights[end]) {
            return false;
        }
        start += 1;
        end -= 1;
    }

    return true;
}

// Test Cases
describe('willItFly vs canItTakeOff equivalence tests', () => {
    const testCases = [
        [[1, 2, 3, 2, 1], 10],
        [[1, 2, 3, 4, 5], 15],
        [[1, 1, 1, 1], 4],
        [[1, 2, 2, 1], 6],
        [[1], 1],
        [[], 0],
        [[5, 5, 5, 5], 20],
        [[5, 5, 5, 5], 19],
        [[1, 2, 3, 4, 3, 2, 1], 20],
        [[1, 2, 3, 4, 5, 6, 7], 28]
    ];

    test.each(testCases)('Input: %o, Max Weight: %d', (weights, maxWeight) => {
        expect(willItFly(weights, maxWeight)).toBe(canItTakeOff(weights, maxWeight));
    });
});