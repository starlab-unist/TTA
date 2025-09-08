function nextSmallest(arr) {
    const uniqueSortedArr = Array.from(new Set(arr)).sort((a, b) => a - b);
    return uniqueSortedArr.length < 2 ? null : uniqueSortedArr[1];
}