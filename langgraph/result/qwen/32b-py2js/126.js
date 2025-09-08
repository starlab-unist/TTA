function isSorted(arr) {
    const countDigit = arr.reduce((acc, num) => {
        acc[num] = (acc[num] || 0) + 1;
        return acc;
    }, {});

    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }

    for (let i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }

    return true;
}