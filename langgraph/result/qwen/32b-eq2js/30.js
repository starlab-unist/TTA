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