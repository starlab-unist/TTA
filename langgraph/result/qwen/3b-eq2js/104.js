function filterOddDigitNumbers(numbers) {
    let oddDigitNumbers = [];
    const iterator = numbers[Symbol.iterator]();

    while (true) {
        try {
            const number = iterator.next().value;
            if (Array.from(number.toString()).every(digit => parseInt(digit) % 2 !== 0)) {
                oddDigitNumbers.push(number);
            }
        } catch (StopIteration) {
            break;
        }
    }

    return oddDigitNumbers.sort((a, b) => a - b);
}