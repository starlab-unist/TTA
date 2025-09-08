function weaveNumbers(numbers, delimiter) {
    if (!numbers.length) {
        return [];
    }

    let interleaved = [];
    let index = 0;

    while (index < numbers.length - 1) {
        interleaved.push(numbers[index]);
        interleaved.push(delimiter);
        index += 1;
    }

    interleaved.push(numbers[numbers.length - 1]);

    return interleaved;
}

// Example usage:
console.log(weaveNumbers([1, 2, 3, 4], 5)); // Output: [1, 5, 2, 5, 3, 5, 4]