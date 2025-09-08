function nearestWholeNumber(inputValue) {
    const floor = Math.floor;
    const ceil = Math.ceil;

    if (inputValue.includes('.')) {
        // strip trailing zeros
        while (inputValue.endsWith('0')) {
            inputValue = inputValue.slice(0, -1);
        }
    }

    let number = parseFloat(inputValue);
    if (inputValue.endsWith('.5')) {
        result = number > 0 ? ceil(number) : floor(number);
    } else if (inputValue) {
        result = Math.round(number);
    } else {
        result = 0;
    }

    return result;
}

// method name: closest_integer -> nearestWholeNumber
// parameter name: value -> inputValue
// replaced value.count('.') == 1 with inputValue.includes('.')
// replaced while loop condition (value[-1] == '0') with inputValue.endsWith('0')
// used inputValue.endsWith('.5') instead of value[-2:] == '.5'
// simplified the elif condition to just check if inputValue is not empty
// used Math.round(number) directly in the elif block