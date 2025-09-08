function monotonic(arr) {
    const sortedArr = [...arr].sort((a, b) => a - b);
    const reversedArr = [...arr].sort((a, b) => b - a);
    return JSON.stringify(arr) === JSON.stringify(sortedArr) || JSON.stringify(arr) === JSON.stringify(reversedArr);
}