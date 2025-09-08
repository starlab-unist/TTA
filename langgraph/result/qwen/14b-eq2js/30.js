function extractPositiveNumbers(inputList) {
    const positiveNumbers = [];
    let index = 0;

    while (index < inputList.length) {
        if (inputList[index] > 0) {
            positiveNumbers.push(inputList[index]);
        }
        index += 1;
    }

    return positiveNumbers;
}

// method name: get_positive -> extractPositiveNumbers
// parameter name: l -> inputList
// replaced list comprehension with a while loop and explicit array pushing
// introduced an index variable to iterate through the array