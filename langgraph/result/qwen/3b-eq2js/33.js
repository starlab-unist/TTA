function sortThird(inputList) {
    const elementsToSort = inputList.filter((_, index) => index % 3 === 0);
    elementsToSort.sort((a, b) => a - b);
    const result = [...inputList];
    for (let i = 0; i < elementsToSort.length; i++) {
        result[i * 3] = elementsToSort[i];
    }
    return result;
}