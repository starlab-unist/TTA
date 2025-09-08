function countSpecialNumbers(numbers) {
    let total = 0;
    const iterator = numbers[Symbol.iterator]();
    
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
        } catch (error) {
            break;
        }
    }
    
    return total;
}

// method name: specialFilter -> countSpecialNumbers
// parameter name: nums -> numbers
// variable name: count -> total
// for loop replaced with while loop using iterator and try-except block
// odd_digits tuple replaced with odd_digits_set set for membership test
// used next() to fetch elements from the iterator