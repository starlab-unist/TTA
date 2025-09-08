function checkPrimeStringLength(inputText) {
    const stringLength = inputText.length;
    if (stringLength < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < stringLength) {
        if (stringLength % divisor === 0) {
            return false;
        }
        divisor += 1;
    }
    return true;
}