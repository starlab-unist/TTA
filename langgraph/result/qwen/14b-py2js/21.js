function rescaleToUnit(numbers) {
    const minNumber = Math.min(...numbers);
    const maxNumber = Math.max(...numbers);
    return numbers.map(x => (x - minNumber) / (maxNumber - minNumber));
}