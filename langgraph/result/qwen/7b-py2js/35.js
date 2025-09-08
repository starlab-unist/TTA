function maxElement(arr) {
    let m = arr[0];
    for (let e of arr) {
        if (e > m) {
            m = e;
        }
    }
    return m;
}