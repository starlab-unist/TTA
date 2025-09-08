function checkSumOfTwoEqualsThird(a, b, c) {
    const allIntegers = [a, b, c].every((i) => typeof i === 'number' && Number.isInteger(i));
    if (!allIntegers) {
        return false;
    }
    return (a + b === c) || (a + c === b) || (b + c === a);
}