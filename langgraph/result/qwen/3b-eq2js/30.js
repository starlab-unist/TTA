function extractPositiveNumbers(inputList) {
    const positiveNumbers = [];
    let index = 0;

    while (index < inputList.length) {
        if (inputList[index] > 0) {
            positiveNumbers.push(inputList[index]);
        }
        index++;
    }

    return positiveNumbers;
}

// method name: getPositive -> extractPositiveNumbers
// parameter name: l -> inputList
// replaced list comprehension with a while loop and explicit list appending
// introduced an index variable to iterate through the list