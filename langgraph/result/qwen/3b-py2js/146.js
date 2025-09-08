function specialFilter(nums) {
    let count = 0;
    for (let num of nums) {
        if (num > 10) {
            const oddDigits = [1, 3, 5, 7, 9];
            const numberAsString = num.toString();
            if (oddDigits.includes(parseInt(numberAsString[0])) && oddDigits.includes(parseInt(numberAsString[numberAsString.length - 1]))) {
                count += 1;
            }
        }
    }
    return count;
}