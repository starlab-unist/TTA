function isSorted(arr) {
    let countDigit = {};
    arr.forEach(i => {
        if (countDigit[i]) {
            countDigit[i]++;
        } else {
            countDigit[i] = 1;
        }
    });
    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }
    if (arr.every((value, index, array) => index === 0 || value >= array[index - 1])) {
        return true;
    } else {
        return false;
    }
}