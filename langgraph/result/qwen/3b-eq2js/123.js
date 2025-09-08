function extractOddNumbersInSequence(startingValue) {
    let sequenceOfOdds = [];
    if (startingValue % 2 === 0) {
        sequenceOfOdds = [];
    } else {
        sequenceOfOdds = [startingValue];
    }

    let currentValue = startingValue;
    while (currentValue > 1) {
        if (currentValue % 2 === 0) {
            currentValue = Math.floor(currentValue / 2);
        } else {
            currentValue = currentValue * 3 + 1;
        }

        if (currentValue % 2 !== 0) {
            sequenceOfOdds.push(currentValue);
        }
    }

    return sequenceOfOdds.sort((a, b) => a - b);
}

// method name: getOddCollatz -> extractOddNumbersInSequence
// parameter name: n -> startingValue
// variable name: oddCollatz -> sequenceOfOdds, n -> currentValue
// replaced n = n/2 with currentValue = Math.floor(currentValue / 2) for integer division
// changed if n%2 == 1 to if currentValue % 2 !== 0 for clarity
// kept the logic and output the same