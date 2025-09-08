function moveOneBall(arr) {
    if (arr.length === 0) {
        return true;
    }
    let sortedArray = [...arr].sort((a, b) => a - b);
    let myArr = [];
    
    let minValue = Math.min(...arr);
    let minIndex = arr.indexOf(minValue);
    myArr = [...arr.slice(minIndex), ...arr.slice(0, minIndex)];
    for (let i = 0; i < arr.length; i++) {
        if (myArr[i] !== sortedArray[i]) {
            return false;
        }
    }
    return true;
}