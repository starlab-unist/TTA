function filterUniqueElements(numList) {
    const countMap = new Map();
    
    // Count occurrences of each number
    for (const num of numList) {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    }
    
    // Filter unique numbers
    const uniqueNumbers = numList.filter(num => countMap.get(num) === 1);
    return uniqueNumbers;
}

// method name: removeDuplicates -> filterUniqueElements
// parameter name: numbers -> numList
// variable name: c -> countMap
// changed the condition in filter from c[n] <= 1 to countMap.get(num) === 1 for clarity
// added a separate line for return statement for better readability