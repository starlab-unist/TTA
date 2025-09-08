function checkSortedAfterRotation(arr) {
    if (!arr.length) {
        return true;
    }

    const orderedArray = [...arr].sort((a, b) => a - b);
    const smallestElement = Math.min(...arr);
    const pivotIndex = arr.indexOf(smallestElement);

    const rotatedArray = arr.slice(pivotIndex).concat(arr.slice(0, pivotIndex));

    for (let idx = 0; idx < arr.length; idx++) {
        if (rotatedArray[idx] !== orderedArray[idx]) {
            return false;
        }
    }

    return true;
}