function median(arr) {
    arr.sort((a, b) => a - b);
    const midIndex = Math.floor(arr.length / 2);

    if (arr.length % 2 === 1) {
        return arr[midIndex];
    } else {
        return (arr[midIndex - 1] + arr[midIndex]) / 2;
    }
}