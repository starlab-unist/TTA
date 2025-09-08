function filterUniqueElements(numList) {
    const countMap = {};
    numList.forEach(num => {
        countMap[num] = (countMap[num] || 0) + 1;
    });
    const uniqueNumbers = numList.filter(num => countMap[num] === 1);
    return uniqueNumbers;
}