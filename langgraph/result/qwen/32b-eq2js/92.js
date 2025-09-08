function checkSumOfTwoEqualsThird(a, b, c) {
    if (Number.isInteger(a) && Number.isInteger(b) && Number.isInteger(c)) {
        if (a + b === c || a + c === b || b + c === a) {
            return true;
        }
        return false;
    }
    return false;
}