function incrementElements(inputList) {
    const result = [];
    let index = 0;
    while (index < inputList.length) {
        result.push(inputList[index] + 1);
        index += 1;
    }
    return result;
}