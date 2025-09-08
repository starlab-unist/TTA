function addElements(arr, k) {
    return arr.slice(0, k).reduce((sum, elem) => {
        return (elem.toString().length <= 2) ? sum + elem : sum;
    }, 0);
}