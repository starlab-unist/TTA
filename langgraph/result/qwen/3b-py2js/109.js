function moveOneBall(arr) {
    if (arr.length === 0) {
        return true;
    }
    const sortedArray = [...arr].sort((a, b) => a - b);
    const myArr = arr.slice(arr.indexOf(Math.min(...arr))).concat(arr.slice(0, arr.indexOf(Math.min(...arr))));
    for (let i = 0; i < arr.length; i++) {
        if (myArr[i] !== sortedArray[i]) {
            return false;
        }
    }
    return true;
}