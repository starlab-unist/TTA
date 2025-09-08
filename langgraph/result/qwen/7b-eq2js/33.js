function sortThird(l) {
    let elementsToSort = l.filter((_, index) => index % 3 === 0);
    elementsToSort.sort((a, b) => a - b);

    let resultList = [...l];
    elementsToSort.forEach((value, index) => {
        resultList[index * 3] = value;
    });

    return resultList;
}