function sortThird(arr) {
    arr = [...arr];
    arr.filter((_, index) => index % 3 === 0).sort().forEach((value, index) => {
        arr[index * 3] = value;
    });
    return arr;
}