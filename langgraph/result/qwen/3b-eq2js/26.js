function filterUniqueElements(numList) {
    const countMap = new Map();
    numList.forEach(num => {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    });
    const uniqueNumbers = numList.filter(num => countMap.get(num) === 1);
    return uniqueNumbers;
}