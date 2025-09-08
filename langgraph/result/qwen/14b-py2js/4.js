function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((sum, num) => sum + num, 0) / numbers.length;
    return numbers.reduce((sum, num) => sum + Math.abs(num - mean), 0) / numbers.length;
}