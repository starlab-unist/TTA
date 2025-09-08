function canArrange(arr) {
    let ind = -1;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
            ind = i;
        }
    }
    return ind;
}