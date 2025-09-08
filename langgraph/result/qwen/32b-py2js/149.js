function sortedListSum(lst) {
    lst.sort();
    const newLst = lst.filter(i => i.length % 2 === 0);
    return newLst.sort((a, b) => a.length - b.length);
}