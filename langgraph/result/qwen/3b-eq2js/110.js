function compareParity(listA, listB) {
    let oddCount = 0;
    let evenCount = 0;
    let index = 0;

    while (index < listA.length) {
        if (listA[index] % 2 !== 0) {
            oddCount++;
        }
        index++;
    }

    index = 0;
    while (index < listB.length) {
        if (listB[index] % 2 === 0) {
            evenCount++;
        }
        index++;
    }

    return evenCount >= oddCount ? "YES" : "NO";
}