function extractPositiveNumbers(l) {
    let positiveNumbers = [];
    let index = 0;

    while (index < l.length) {
        if (l[index] > 0) {
            positiveNumbers.push(l[index]);
        }
        index++;
    }

    return positiveNumbers;
}

// method name: get_positive -> extractPositiveNumbers
// parameter name: l -> input_list
// replaced list comprehension with a while loop and explicit array pushing
// introduced an index variable to iterate through the array