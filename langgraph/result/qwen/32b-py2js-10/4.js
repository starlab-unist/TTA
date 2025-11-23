function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((acc, val) => acc + val, 0) / numbers.length;
    return numbers.reduce((acc, val) => acc + Math.abs(val - mean), 0) / numbers.length;
}