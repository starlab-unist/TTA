// Source Code
function rollingMax(numbers) {
    let runningMax = null;
    const result = [];

    for (let n of numbers) {
        if (runningMax === null) {
            runningMax = n;
        } else {
            runningMax = Math.max(runningMax, n);
        }

        result.push(runningMax);
    }

    return result;
}

// Transformed Code (Semantically Equivalent)
function computeRollingMaximum(numbers) {
    let currentMax = null;
    const maxHistory = [];

    let index = 0;
    while (index < numbers.length) {
        if (currentMax === null || numbers[index] > currentMax) {
            currentMax = numbers[index];
        }

        maxHistory.push(currentMax);
        index++;
    }

    return maxHistory;
}

// Test Cases
describe('rollingMax vs computeRollingMaximum equivalence tests', () => {
    const testCases = [
        [[], []],
        [[5], [5]],
        [[1, 2, 3, 4, 5], [1, 2, 3, 4, 5]],
        [[5, 4, 3, 2, 1], [5, 5, 5, 5, 5]],
        [[1, 5, 3, 6, 2], [1, 5, 5, 6, 6]],
        [[3, 3, 3, 3, 3], [3, 3, 3, 3, 3]],
        [[10, 9, 8, 7, 11], [10, 10, 10, 10, 11]],
        [[1, 2], [1, 2]],
        [[2, 1], [2, 2]],
        [[1], [1]]
    ];

    test.each(testCases)('Input: "%s"', (inputNumbers, expectedOutput) => {
        expect(rollingMax(inputNumbers)).toEqual(computeRollingMaximum(inputNumbers));
    });
});