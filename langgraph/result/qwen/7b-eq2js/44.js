function convertToBase(number, targetBase) {
    let result = "";
    while (number > 0) {
        const remainder = number % targetBase;
        result = remainder.toString() + result;
        number = Math.floor(number / targetBase);
    }
    return result;
}