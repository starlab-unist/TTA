function extractOddNumbersInSequence(n) {
    let oddCollatz = [];
    if (n % 2 === 0) {
        oddCollatz = [];
    } else {
        oddCollatz.push(n);
    }

    let currentValue = n;
    while (currentValue > 1) {
        if (currentValue % 2 === 0) {
            currentValue /= 2;
        } else {
            currentValue = currentValue * 3 + 1;
        }

        if (currentValue % 2 !== 0) {
            oddCollatz.push(currentValue);
        }
    }

    return oddCollatz.sort((a, b) => a - b);
}