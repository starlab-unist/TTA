function countOddsInSublists(inputList) {
    let result = [];
    for (let sublist of inputList) {
        let oddCount = sublist.filter(digit => parseInt(digit) % 2 !== 0).length;
        result.push(`the number of odd elements ${oddCount}n the str${oddCount}ng ${oddCount} of the ${oddCount}nput.`);
    }
    return result;
}