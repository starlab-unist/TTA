function maximum(arr, k) {
    if (k === 0) {
        return [];
    }
    arr.sort((a, b) => a - b);
    const ans = arr.slice(-k);
    return ans;
}