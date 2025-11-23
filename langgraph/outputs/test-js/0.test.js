function hasCloseElements(numbers, threshold) {
    for (let idx = 0; idx < numbers.length; idx++) {
        for (let idx2 = 0; idx2 < numbers.length; idx2++) {
            if (idx !== idx2) {
                const distance = Math.abs(numbers[idx] - numbers[idx2]);
                if (distance < threshold) {
                    return true;
                }
            }
        }
    }

    return false;
}
function containsNearbyElements(values, limit) {
    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return false;
}
describe('hasCloseElements vs containsNearbyElements equivalence tests', () => {
    const testCases = [
        [[1, 2, 3], 1],
        [[1, 1.5, 3], 1],
        [[1, 1, 3], 0.1],
        [[1, 2, 3], 0.5],
        [[], 0.5],
        [[5], 0.5],
        [[1, 2, 1], 0.5],
        [[1, 3, 5], 2.1],
        [[1, 3, 5], 2],
        [[1, 3, 5, 1.5], 0.6]
    ];

    test.each(testCases)('Input: %p, Threshold: %f', (numbers, threshold) => {
        expect(hasCloseElements(numbers, threshold)).toBe(containsNearbyElements(numbers, threshold));
    });
});