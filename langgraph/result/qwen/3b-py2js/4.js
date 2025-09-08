function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((acc, num) => acc + num, 0) / numbers.length;
    return numbers.reduce((acc, num) => acc + Math.abs(num - mean), 0) / numbers.length;
}