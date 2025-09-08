function median(arr) {
    arr.sort((a, b) => a - b);
    const mid = Math.floor(arr.length / 2);
    if (arr.length % 2 === 1) {
        return arr[mid];
    } else {
        return (arr[mid - 1] + arr[mid]) / 2.0;
    }
}