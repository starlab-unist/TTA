function sortThird(arr) {
    arr = [...arr]; // Create a copy of the array
    arr.splice(0, 0, ...arr.slice(0, arr.length).filter((_, index) => index % 3 === 0).sort((a, b) => a - b));
    return arr;
}