function incrementElements(inputList) {
    let result = [];
    let index = 0;
    while (index < inputList.length) {
        result.push(inputList[index] + 1);
        index++;
    }
    return result;
}

// method name: incrList -> incrementElements
// parameter name: l -> inputList
// replaced list comprehension with a while loop and explicit list appending