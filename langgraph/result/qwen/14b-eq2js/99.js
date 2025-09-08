function nearestWholeNumber(inputValue) {
    const { floor, ceil } = Math;

    if (inputValue.includes('.')) {
        // strip trailing zeros
        while (inputValue.endsWith('0')) {
            inputValue = inputValue.slice(0, -1);
        }
    }

    const number = parseFloat(inputValue);
    let result;

    if (inputValue.endsWith('.5')) {
        result = number > 0 ? ceil(number) : floor(number);
    } else if (inputValue) {
        result = Math.round(number);
    } else {
        result = 0;
    }

    return result;
}