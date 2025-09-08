function countOddsInSublists(inputList) {
    const result = [];
    for (const sublist of inputList) {
        const oddCount = sublist.reduce((count, digit) => count + (parseInt(digit) % 2 !== 0 ? 1 : 0), 0);
        result.push(`the number of odd elements ${oddCount}n the str${oddCount}ng ${oddCount} of the ${oddCount}nput.`);
    }
    return result;
}