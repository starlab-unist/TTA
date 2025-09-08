function evaluateDifference(actual, playerGuess) {
    let differences = [];
    let index = 0;
    while (index < actual.length) {
        differences.push(Math.abs(actual[index] - playerGuess[index]));
        index += 1;
    }
    return differences;
}