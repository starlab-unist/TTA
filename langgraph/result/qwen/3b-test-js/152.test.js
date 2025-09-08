// Source Code
function compare(game, guess) {
    return game.map((x, index) => Math.abs(x - guess[index]));
}

// Transformed Code (Semantically Equivalent)
function evaluateDifference(actual, playerGuess) {
    const differences = [];
    let index = 0;
    while (index < actual.length) {
        differences.push(Math.abs(actual[index] - playerGuess[index]));
        index++;
    }
    return differences;
}

// Test Cases
describe('compare vs evaluateDifference equivalence tests', () => {
    const testCases = [
        [[1, 2, 3], [1, 2, 3]],
        [[4, 5, 6], [7, 8, 9]],
        [[0, 0, 0], [1, 1, 1]],
        [[-1, -2, -3], [-1, -2, -3]],
        [[10, 20, 30], [30, 20, 10]],
        [[100, 200, 300], [150, 250, 350]],
        [[1, 1, 1, 1, 1], [1, 1, 1, 1, 1]],
        [[1, 2, 3, 4, 5], [5, 4, 3, 2, 1]],
        [[0, 1, 2, 3, 4], [4, 3, 2, 1, 0]],
        [[-5, -10, -15], [-15, -10, -5]]
    ];

    test.each(testCases)('Input: game=%s, guess=%s', (game, guess) => {
        expect(compare(game, guess)).toEqual(evaluateDifference(game, guess));
    });
});