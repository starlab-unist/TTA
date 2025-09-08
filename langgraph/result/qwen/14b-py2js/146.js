function specialFilter(nums) {
    let count = 0;
    const oddDigits = new Set([1, 3, 5, 7, 9]);

    for (let num of nums) {
        if (num > 10) {
            const numberAsString = num.toString();
            if (oddDigits.has(parseInt(numberAsString[0])) && oddDigits.has(parseInt(numberAsString[numberAsString.length - 1]))) {
                count += 1;
            }
        }
    }

    return count;
}