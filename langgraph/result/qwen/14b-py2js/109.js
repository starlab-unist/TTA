function moveOneBall(arr) {
    if (arr.length === 0) {
        return true;
    }
    const sortedArray = [...arr].sort((a, b) => a - b);
    let myArr = [];
    
    const minValue = Math.min(...arr);
    const minIndex = arr.indexOf(minValue);
    myArr = arr.slice(minIndex).concat(arr.slice(0, minIndex));
    for (let i = 0; i < arr.length; i++) {
        if (myArr[i] !== sortedArray[i]) {
            return false;
        }
    }
    return true;
}