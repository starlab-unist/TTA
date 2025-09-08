function sortedListSum(lst) {
    lst.sort();
    const newLst = [];
    for (const i of lst) {
        if (i.length % 2 === 0) {
            newLst.push(i);
        }
    }
    return newLst.sort((a, b) => a.length - b.length);
}