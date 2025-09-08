function extractOddNumbersInSequence(startingValue) {
    let sequenceOfOdds;
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