function checkPrimeStringLength(inputText) {
    let stringLength = inputText.length;
    if (stringLength < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < stringLength) {
        if (stringLength % divisor === 0) {
            return false;
        }
        divisor++;
    }
    return true;
}

// method name: checkPrimeStringLength
// parameter name: inputText
// variable name: stringLength, divisor
// replaced for loop with while loop
// simplified the initial if condition to stringLength < 2