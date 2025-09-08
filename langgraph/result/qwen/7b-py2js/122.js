function addElements(arr, k) {
    return arr.slice(0, k).reduce((sum, elem) => {
        const strElem = elem.toString();
        return strElem.length <= 2 ? sum + elem : sum;
    }, 0);
}