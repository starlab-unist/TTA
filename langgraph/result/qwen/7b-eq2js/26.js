const filterUniqueElements = (numbers) => {
    const countMap = {};
    numbers.forEach((num) => {
        countMap[num] = (countMap[num] || 0) + 1;
    });
    const uniqueNumbers = numbers.filter((num) => countMap[num] === 1);
    return uniqueNumbers;
};

// method name: removeDuplicates -> filterUniqueElements
// parameter name: numbers -> numList
// variable name: c -> countMap
// changed the condition in list comprehension from c[n] <= 1 to countMap[num] == 1 for clarity
// added a separate line for return statement for better readability