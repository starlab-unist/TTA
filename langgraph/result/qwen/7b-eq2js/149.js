function evenLengthSortedElements(lst) {
    lst.sort();
    const newLst = lst.filter(element => element.length % 2 === 0);
    return newLst.sort((a, b) => a.length - b.length);
}