function sortedListSum(lst) {
    lst.sort();
    let newLst = [];
    for (let i of lst) {
        if (i.length % 2 === 0) {
            newLst.push(i);
        }
    }
    return newLst.sort((a, b) => a.length - b.length);
}