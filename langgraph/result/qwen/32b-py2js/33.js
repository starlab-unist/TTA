function sortThird(arr) {
    arr = [...arr];
    const thirdElements = arr.filter((_, index) => index % 3 === 0).sort((a, b) => a - b);
    let thirdIndex = 0;
    for (let i = 0; i < arr.length; i += 3) {
        arr[i] = thirdElements[thirdIndex++];
    }
    return arr;
}