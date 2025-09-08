function normalizeValues(numbers) {
    const minValue = Math.min(...numbers);
    const maxValue = Math.max(...numbers);
    const rangeValue = maxValue - minValue;

    const normalizedList = [];
    for (const number of numbers) {
        const normalizedNumber = (number - minValue) / rangeValue;
        normalizedList.push(normalizedNumber);
    }

    return normalizedList;
}
// method name: rescaleToUnit -> normalizeValues
// parameter name: numbers -> values
// variable name: minNumber -> minValue, maxNumber -> maxValue
// introduced rangeValue to store the difference between largest and smallest values
// replaced list comprehension with a for loop to append each normalized value