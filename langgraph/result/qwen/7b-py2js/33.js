function sortThird(arr) {
    arr = arr.slice();
    for (let i = 0; i < arr.length; i += 3) {
        let tempArr = [];
        for (let j = i; j < Math.min(i + 3, arr.length); j++) {
            tempArr.push(arr[j]);
        }
        tempArr.sort((a, b) => a - b);
        for (let j = i, k = 0; j < Math.min(i + 3, arr.length); j++, k++) {
            arr[j] = tempArr[k];
        }
    }
    return arr;
}