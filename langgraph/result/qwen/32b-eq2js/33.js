function arrangeEveryThirdElement(inputList) {
    const elementsToSort = inputList.filter((_, index) => index % 3 === 0);
    elementsToSort.sort();
    const resultList = [...inputList];
    elementsToSort.forEach((value, index) => {
        resultList[index * 3] = value;
    });
    return resultList;
}

// method name: sortThird -> arrangeEveryThirdElement
// parameter name: l -> inputList
// created a separate array elementsToSort for clarity
// used a forEach loop to place sorted elements back into their positions
// changed the way the sorted elements are placed back into the array