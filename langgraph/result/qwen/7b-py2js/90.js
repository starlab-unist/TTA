function nextSmallest(arr) {
    arr = [...new Set(arr)].sort((a, b) => a - b);
    return arr.length < 2 ? null : arr[1];
}