function evaluateDifference(actual, playerGuess) {
    const differences = [];
    let index = 0;
    while (index < actual.length) {
        differences.push(Math.abs(actual[index] - playerGuess[index]));
        index++;
    }
    return differences;
}