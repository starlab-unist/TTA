function countSpecialNumbers(nums) {
    let total = 0;
    const iterator = nums[Symbol.iterator]();
    
    while (true) {
        try {
            const currentNumber = iterator.next().value;
            if (currentNumber > 10) {
                const oddDigitsSet = new Set([1, 3, 5, 7, 9]);
                const numStr = currentNumber.toString();
                if (oddDigitsSet.has(parseInt(numStr[0])) && oddDigitsSet.has(parseInt(numStr[numStr.length - 1]))) {
                    total++;
                }
            }
        } catch (e) {
            break;
        }
    }
    
    return total;
}