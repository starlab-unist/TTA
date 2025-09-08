function maximum(arr, k) {
    if (k === 0) {
        return [];
    }
    arr.sort((a, b) => a - b);
    return arr.slice(-k);
}