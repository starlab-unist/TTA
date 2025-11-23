function rollingMax(numbers) {
    let runningMax = null;
    const result = [];

    for (const n of numbers) {
        if (runningMax === null) {
            runningMax = n;
        } else {
            runningMax = Math.max(runningMax, n);
        }

        result.push(runningMax);
    }

    return result;
}

function computeRollingMaximum(values) {
    let currentMax = null;
    const maxHistory = [];

    let index = 0;
    while (index < values.length) {
        if (currentMax === null) {
            currentMax = values[index];
        } else if (values[index] > currentMax) {
            currentMax = values[index];
        }

        maxHistory.push(currentMax);
        index += 1;
    }

    return maxHistory;
}

describe('rollingMax vs computeRollingMaximum equivalence tests', () => {
    const testCases = [
        [],
        [1],
        [1, 2, 3, 4],
        [4, 3, 2, 1],
        [1, 3, 2, 4],
        [5, 4, 5, 3, 6]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(rollingMax(inputArray)).toEqual(computeRollingMaximum(inputArray));
    });
});