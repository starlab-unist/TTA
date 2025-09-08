function isMonotonic(arr) {
    const sortedArr = [...arr].sort((a, b) => a - b);
    const reversedArr = [...arr].sort((a, b) => b - a);

    return arr.every((value, index) => value === sortedArr[index]) ||
           arr.every((value, index) => value === reversedArr[index]);
}