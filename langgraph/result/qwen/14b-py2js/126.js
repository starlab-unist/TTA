function isSorted(lst) {
    const countDigit = {};
    lst.forEach(i => {
        countDigit[i] = (countDigit[i] || 0) + 1;
    });
    if (lst.some(i => countDigit[i] > 2)) {
        return false;
    }
    if (lst.every((_, i) => i === 0 || lst[i - 1] <= lst[i])) {
        return true;
    } else {
        return false;
    }
}