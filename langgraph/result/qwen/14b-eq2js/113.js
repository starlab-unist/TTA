function countOddsInSublists(inputList) {
    const result = [];
    for (const sublist of inputList) {
        let oddCount = 0;
        for (const digit of sublist) {
            if (parseInt(digit) % 2 !== 0) {
                oddCount++;
            }
        }
        result.push(`the number of odd elements ${oddCount}n the str${oddCount}ng ${oddCount} of the ${oddCount}nput.`);
    }
    return result;
}

// method name: odd_count -> countOddsInSublists
// parameter name: lst -> inputList
// variable name: res -> result, arr -> sublist, n -> oddCount
// replaced the generator expression with a more readable sum with a conditional
// used template literals for string formatting instead of concatenation